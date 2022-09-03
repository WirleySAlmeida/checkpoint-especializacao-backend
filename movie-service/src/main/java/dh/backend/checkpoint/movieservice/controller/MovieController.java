package dh.backend.checkpoint.movieservice.controller;

import dh.backend.checkpoint.movieservice.dto.MovieDTO;
import dh.backend.checkpoint.movieservice.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(dto));
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<MovieDTO>> findByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.findByGenre(genre));
    }
}
