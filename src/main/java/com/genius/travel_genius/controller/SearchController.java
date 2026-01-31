package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.SearchFilterDTO;
import com.genius.travel_genius.dto.SearchResponseDTO;
import com.genius.travel_genius.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public ResponseEntity<List<SearchResponseDTO>> search(@RequestBody SearchFilterDTO filterDTO) {
        return ResponseEntity.ok(searchService.search(filterDTO));
    }
}
