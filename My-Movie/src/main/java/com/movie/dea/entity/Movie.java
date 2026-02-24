package com.movie.dea.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private Double rating;
    private Integer duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;
    public Movie() {
    }
    public Movie(Integer id, String title, String genre, LocalDate releaseDate, Double rating, Integer duration) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.duration = duration;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}