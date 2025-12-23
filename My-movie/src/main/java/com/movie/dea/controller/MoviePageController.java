package com.movie.dea.controller;

import com.movie.dea.entity.Movie;
import com.movie.dea.service.MovieService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MoviePageController {
    private final MovieService movieService;

    public MoviePageController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("movies", movieService.getAllMovie());
        return "movies/list";
    }


    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("movie", new Movie());
        return "movies/new";
    }

    @PostMapping
    public String save(@ModelAttribute Movie movie) {
        movieService.createMovie(movie);
        return "redirect:/movies";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id,Model model){
        model.addAttribute("movie", movieService.getMovie(id));
        return "movies/edit";
    }
}


































//
//package com.movie.dea.controller;
//
//import com.movie.dea.entity.MovieDetails;
//import com.movie.dea.service.MovieDetailsService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping ("/details")
//public class MovieDetailsController {
//    private final MovieDetailsService movieDetailsService;
//
//    public MovieDetailsController(MovieDetailsService movieDetailsService) {
//        this.movieDetailsService = movieDetailsService;
//    }
//
//    @GetMapping("/all")
//    public List<MovieDetails> getAllDetails() {
//        return movieDetailsService.getAllDetails();
//    }
//
//    @GetMapping("/{id}")
//    public MovieDetails getDetailsById(@PathVariable Integer id) {
//        return movieDetailsService.getDetailsById(id);
//    }
//
//    @PostMapping("/add")
//    public MovieDetails createNewDetails(@RequestBody MovieDetails movieDetails) {
//        return movieDetailsService.createDetails(movieDetails);
//    }
//}






























































//package com.movie.dea.controller;
//
//import com.movie.dea.service.MovieService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/movies")
//public class MoviePageController {
//
//    private final MovieService movieService;
//
//    public MoviePageController(MovieService movieService) {
//        this.movieService = movieService;
//    }
//
//    @GetMapping
//    public String list(Model model) {
//        model.addAttribute("movies", movieService.getAllMovie());
//        return "movies/list";
//    }
//
//    // @GetMapping("/all")
//    // public List<Movie> getMovies() {
//    //     return movieService.getAllMovie();
//    // }
//}