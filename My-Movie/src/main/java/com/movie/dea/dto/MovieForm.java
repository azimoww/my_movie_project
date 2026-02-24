package com.movie.dea.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;
@Data
public class MovieForm {
    private Integer id;
    @NotBlank(message = "Title required")
    @Size(min = 8, max = 50, message = "The limit has been exceeded, min 8, max 50")
    private String title;
    @NotBlank(message = "ReleaseDate required")
    private String releaseDate;
    @Size(min = 2, max = 3, message = "The limit has been exceeded, min 2, max 3")
    @NotBlank(message = "Duration required")
    private String duration;
    @NotBlank(message = "Genre required")
    @Size(min = 5, max = 20, message = "The limit has been exceeded, min 5, max 20")
    private String genre;
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
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public LocalDate getReleaseDate() {
        return LocalDate.parse(releaseDate);///////////////////////////////////////
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = String.valueOf(releaseDate);
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setRating(Double rating) {
    }
    public Double getRating() {
        return 0.0;
    }

    public void setDirectorId(Integer id) {

    }
    public Integer getDirectorId() {

        return 0;
    }
}