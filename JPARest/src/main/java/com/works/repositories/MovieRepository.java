package com.works.repositories;

import com.works.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Page<Movie> findByTitleContainsOrDetailContainsAllIgnoreCase(String title, String detail, Pageable pageable);

    List<Movie> findByCategories_CidEquals(Long cid);



}