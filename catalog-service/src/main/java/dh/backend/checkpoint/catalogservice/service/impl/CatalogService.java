package dh.backend.checkpoint.catalogservice.service.impl;

import dh.backend.checkpoint.catalogservice.dto.MovieDTO;
import dh.backend.checkpoint.catalogservice.service.MovieFeign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private MovieFeign movieFeign;

    public CatalogService(MovieFeign movieFeign) {
        this.movieFeign = movieFeign;
    }

    public List<MovieDTO> findByGenre(String genre) {
        return movieFeign.findByGenre(genre).getBody();
    }
}
