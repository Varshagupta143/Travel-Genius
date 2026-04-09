package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.AuthResponseDTO;
import com.genius.travel_genius.dto.LoginDTO;
import com.genius.travel_genius.dto.UserDTO;
import com.genius.travel_genius.mapper.UserMapper;
import com.genius.travel_genius.models.User;
import com.genius.travel_genius.repository.UserRepository;
import com.genius.travel_genius.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    public User registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
            log.info("Mapping User dto to User entity");
        User newUser = userMapper.toUserEntity(userDTO);

        // ✅ Encrypt password
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        log.info("User mapped and now saving to database");
        return userRepository.save(newUser);

    }

//    public String login(LoginDTO loginDTO) {
//        if (loginDTO.getEmail() != null) {
//            return userLoginWithEmail(loginDTO);
//        } else if (loginDTO.getMobileNumber() != null) {
//            return userLoginWithMobileNumber(loginDTO);
//        }
//        return "Enter either Email or MobileNumber";
//
//    }
public AuthResponseDTO login(LoginDTO loginDTO) {

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginDTO.getEmail(),
                    loginDTO.getPassword()
            )
    );

    String token = jwtUtil.generateToken(loginDTO.getEmail());

    return new AuthResponseDTO(token, loginDTO.getEmail());
}

//    private AuthResponseDTO userLoginWithEmail(LoginDTO loginDTO) {
//        User user = userRepository.getUserByEmail(loginDTO.getEmail());
//
//        if (user != null) {
//            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
//                String token = jwtUtil.generateToken(user.getEmail());
//                return new AuthResponseDTO(token, user.getEmail());
//            } else {
//                throw new RuntimeException("Wrong password");
//            }
//        } else {
//            throw new RuntimeException("Email not found");
//        }
//
//    }
    public boolean checkEmailExists(String email){
        return userRepository.existsByEmail(email);
    }
    private AuthResponseDTO userLoginWithMobileNumber(LoginDTO loginDTO) {
        log.info("Login attempt for MobileNumber: {}", loginDTO.getMobileNumber());
        User user = userRepository.getUserByMobileNumber(loginDTO.getMobileNumber());
        if (user != null) {
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword()))  {
                log.info("Login successful for MobileNUmber: {}", loginDTO.getMobileNumber());
                String token = jwtUtil.generateToken(user.getEmail());

                return new AuthResponseDTO(token, user.getEmail());
            } else {
                throw new RuntimeException("Wrong password");
            }
        } else {

            throw new RuntimeException("Wrong password");
        }
    }
}
