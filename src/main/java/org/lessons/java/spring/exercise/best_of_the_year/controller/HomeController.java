package org.lessons.java.spring.exercise.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;
import org.lessons.java.spring.exercise.model.Movie;
import org.lessons.java.spring.exercise.model.Song;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    // metodo per richiamare la homepage
    @GetMapping("/")
    public String Home(Model model, String name) {
        model.addAttribute("name", "Luca");
        return "index";
    }

    // metodi per creare due liste di oggetti che conterranno bestSongs e bestMovies

    private List<Movie> getBestMovies() {
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie(1, "Psycho"));
        movieList.add(new Movie(2, "Memento"));
        movieList.add(new Movie(3, "Perfect Day"));
        movieList.add(new Movie(4, "The Truman Show"));
        movieList.add(new Movie(5, "L'armata delle tenebre"));
        return movieList;
    }

    private List<Song> getBestSongs() {
        List<Song> songList = new ArrayList<Song>();
        songList.add(new Song(1, "Sober"));
        songList.add(new Song(2, "Imagine"));
        songList.add(new Song(3, "Paranoid"));
        songList.add(new Song(4, "Crazy Train"));
        songList.add(new Song(5, "Wicked Game"));

        return songList;
    }

    // metodo per richiamare la pagina dei film

    @GetMapping("/films")
    public String goMovies(Model model) {
        model.addAttribute("list", getBestMovies());
        return "films";
    }

    // metodo per raggiungere il dettaglio del film tramite id
    @GetMapping("/films/{id}")
    public String filmDetail(Model model, @PathVariable("id") Integer filmId) {
        Movie currentFilm = null;

        for (Movie film : getBestMovies()) {
            if (film.getId().equals(filmId)) {
                currentFilm = film;
            }
        }

        model.addAttribute("id", filmId);
        model.addAttribute("item", currentFilm);
        model.addAttribute("genere", "Film");
        return "detail";
    }

    // metodo per raggiungere il dettaglio della canzone
    @GetMapping("/songs/{id}")
    public String songDetail(Model model, @PathVariable("id") Integer songId) {
        Song currentSong = null;

        for (Song song : getBestSongs()) {
            if (song.getId().equals(songId)) {
                currentSong = song;
            }
        }

        model.addAttribute("id", songId);
        model.addAttribute("item", currentSong);
        model.addAttribute("genere", "Canzone");
        return "detail";
    }

    // metodo per richiamare la pagina delle canzoni
    @GetMapping("/songs")
    public String goSongs(Model model) {
        model.addAttribute("list", getBestSongs());
        return "songs";
    }

    // metodi per restituire la lista dei film e delle canzoni come una stringa
    // @GetMapping("/string/films")
    // public String filmsToString(Model model) {

    // String filmsList = "";
    // for (Movie movie : getBestMovies()) {

    // filmsList += movie.getTitle() + ", ";

    // }

    // model.addAttribute("Title", "Film");
    // model.addAttribute("List", filmsList);

    // return "filmsList";
    // }

    // @GetMapping("/string/songs")
    // public String SongsToString(Model model) {

    // String songsList = "";
    // for (Song song : getBestSongs()) {

    // songsList += song.getTitle() + ", ";

    // }

    // return "songsList";
    // }
}