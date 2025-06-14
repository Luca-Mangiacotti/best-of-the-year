package org.lessons.java.spring.exercise.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String Home(Model model, String name) {
        model.addAttribute("name", "Luca");
        return "index";
    }

    @GetMapping("/films")
    public String goMovies() {

        return "films";
    }

    @GetMapping("/songs")
    public String goSongs() {

        return "songs";
    }

}