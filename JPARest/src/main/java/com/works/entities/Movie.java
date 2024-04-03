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

    @Size(min = 0, max = 1500)
    @NotEmpty
    @NotNull
    @Column(length = 1500)
    private String title;

    @Size(min = 0, max = 1500)
    @NotEmpty
    @NotNull
    @Column(length = 1500)
    private String detail;

    @ManyToMany
    private List<Category> categories;

}
