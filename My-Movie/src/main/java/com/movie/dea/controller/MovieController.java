package com.movie.dea.controller;
import com.movie.dea.entity.Movie;
//import com.movie.dea.service.movieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final com.movie.dea.service.MovieService movieService;
    public MovieController(com.movie.dea.service.MovieService movieService) {
        this.MovieService = movieService;
    }
    @GetMapping("/pagination")
    public Page<Movie> getPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return MovieService.getMoviesByPage(page    , size);
    }
    @Operation(summary = "Get All Movies")
    @GetMapping("/all")
    public List<Movie> getMovies(){
        return MovieService.getAllMovie();
    }
    @GetMapping("/rating/{minRating}")
    public List<Movie> getAllMoviesByMinRating(@PathVariable Double minRating) {
        return MovieService.getAllMovieByMinRating(minRating);
    }
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id){
        return MovieService.getMovie(id);
    }
    @GetMapping("/date/{releaseDate}")
    public List<Movie> getMovieByDate(@PathVariable LocalDate releaseDate){
        return MovieService.getAllMovieByReleaseDate(releaseDate);
    }
    @PostMapping("/add")
    public Movie creatMovie(@RequestBody Movie movie) {
        return MovieService.createMovie(movie);
    }
    @PutMapping("/update/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        return MovieService.updateMovie(id, movie);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        MovieService.deleteById(id);
    }
}



//    @GetMapping("/title/{title}")
//    public List<Movie> getMoviesByTitle(@PathVariable String title) {
//        return movieService.getAllMovieByTitle(title);
//    }
//
//    @GetMapping("/genre/{genre}")
//    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
//        return movieService.getAllMovieByGenre(genre);
//    }