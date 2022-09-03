package dh.backend.checkpoint.movieservice.service.impl;

import dh.backend.checkpoint.movieservice.dto.MovieDTO;
import dh.backend.checkpoint.movieservice.entity.Movie;
import dh.backend.checkpoint.movieservice.repository.MovieRepository;
import dh.backend.checkpoint.movieservice.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDTO save(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setName(dto.getName());
        movie.setGenre(dto.getGenre());
        movie.setUrlStream(dto.getUrlStream());
        return entityToDTO(movieRepository.save(movie));
    }

    @Override
    public List<MovieDTO> findByGenre(String genre) {
        return movieRepository.findAllByGenre(genre).stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    private MovieDTO entityToDTO(Movie movie) {
        return MovieDTO.builder()
                .name(movie.getName())
                .genre(movie.getGenre())
                .urlStream(movie.getUrlStream())
                .id(movie.getId())
                .build();
    }
}
