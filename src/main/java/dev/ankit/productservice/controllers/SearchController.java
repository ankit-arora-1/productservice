package dev.ankit.productservice.controllers;

import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.dtos.SearchRequestDto;
import dev.ankit.productservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public Page<GenericProductDto> search(@RequestBody SearchRequestDto searchRequestDto) {
        return searchService.search(searchRequestDto.getQuery(),
                searchRequestDto.getPageSize(),
                searchRequestDto.getPageNumber());
    }
}
