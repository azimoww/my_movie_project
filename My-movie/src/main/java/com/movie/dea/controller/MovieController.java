package com.movie.dea.controller;

import com.movie.dea.entity.Movie;
import com.movie.dea.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Список всех фильмов
    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("mode", "list");
        return "movies/new";
    }

    // Форма создания
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("mode", "form");
        model.addAttribute("formTitle", "New Movie");
        return "movies/new";
    }

    // Форма редактирования (для яркого дизайна Edit Movie)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        model.addAttribute("mode", "form");
        model.addAttribute("formTitle", "Edit Movie");
        return "movies/new";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}