package com.works.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    @Size(min = 3, max = 200)
    @NotEmpty
    @NotNull
    @Column(length = 200)
    private String title;

    @Size(min = 3, max = 500)
    @NotEmpty
    @NotNull
    @Column(length = 500)
    private String detail;

    @ManyToMany
    private List<Category> categories;

}
