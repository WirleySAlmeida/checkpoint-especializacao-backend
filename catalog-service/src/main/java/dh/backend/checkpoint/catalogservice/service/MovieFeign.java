package dh.backend.checkpoint.catalogservice.service;

import dh.backend.checkpoint.catalogservice.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MOVIE-SERVICE")
public interface MovieFeign {

    @GetMapping("/movies/{genre}")
    ResponseEntity<List<MovieDTO>> findByGenre(@PathVariable String genre);
}
