package dh.backend.checkpoint.catalogservice.controller;

import dh.backend.checkpoint.catalogservice.dto.MovieDTO;
import dh.backend.checkpoint.catalogservice.service.impl.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CatalogController {

    private CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieDTO>> findMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(catalogService.findByGenre(genre));
    }

}
