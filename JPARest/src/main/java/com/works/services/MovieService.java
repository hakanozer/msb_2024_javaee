package com.works.services;

import com.works.entities.Movie;
import com.works.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    final MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> addAllMovie( List<Movie> movies ) {
        return movieRepository.saveAll(movies);
    }

    public Page<Movie> allMovie(int pageCount, int pageSize, String attr, String q) {
        Sort sort = Sort.by(attr).ascending();
        int newPageSize = pageSize > 50 ? 10 : pageSize;
        newPageSize = newPageSize < 0 ? 10 : newPageSize;
        Pageable pageable = PageRequest.of(pageCount, newPageSize, sort);
        try {
            return movieRepository.findByTitleContainsOrDetailContainsAllIgnoreCase(q, q, pageable);
        }catch (Exception Ex) {
            pageable = PageRequest.of(pageCount, newPageSize);
            return movieRepository.findByTitleContainsOrDetailContainsAllIgnoreCase(q, q, pageable);
        }
    }

    public List<Movie> category(Long cid) {
        return movieRepository.findByCategories_CidEquals(cid);
    }

}
