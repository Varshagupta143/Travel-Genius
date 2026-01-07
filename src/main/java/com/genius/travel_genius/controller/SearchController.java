package com.genius.travel_genius.controller;
import com.genius.travel_genius.dto.SearchInputDTO;
import com.genius.travel_genius.dto.SearchResultDTO;
import com.genius.travel_genius.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @PostMapping
    public ResponseEntity<List<SearchResultDTO>> search(
            @RequestBody SearchInputDTO inputDTO) {
        return ResponseEntity.ok(searchService.search(inputDTO));
    }
}
