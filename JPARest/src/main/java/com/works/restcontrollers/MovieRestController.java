package com.works.restcontrollers;

import com.works.entities.Movie;
import com.works.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movie")
public class MovieRestController {

    final MovieService movieService;

    @PostMapping("add")
    public Movie add(@RequestBody Movie movie) {
        return  movieService.addMovie(movie);
    }

    @PostMapping("addAll")
    public List<Movie> addAll(@RequestBody List<Movie> movies) {
        return movieService.addAllMovie(movies);
    }

    @GetMapping("allMovie")
    public Page<Movie> allMovie(
            @RequestParam(defaultValue = "0") int pageCount,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "mid") String attr,
            @RequestParam(defaultValue = "") String q
    ) {
        return movieService.allMovie(pageCount, pageSize, attr, q);
    }

    @GetMapping("category/{cid}")
    public List<Movie> category(@PathVariable Long cid) {
        return movieService.category(cid);
    }

}
