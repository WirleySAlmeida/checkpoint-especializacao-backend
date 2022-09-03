package dh.backend.checkpoint.movieservice.service;

import dh.backend.checkpoint.movieservice.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieDTO> findByGenre(String genre);
}
