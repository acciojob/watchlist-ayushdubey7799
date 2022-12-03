package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);

    }
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> createMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        movieService.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> searchMovie(@PathVariable String name) {
        return new ResponseEntity<>(movieService.searchMovie(name), HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> searchDirector(@PathVariable String name){
        return new ResponseEntity<>(movieService.searchDirector(name),HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> searchMovieFromDirector(@PathVariable String director){
        return new ResponseEntity<>(movieService.searchMovieFromDirector(director),HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> searchAllMovies(){
        return new ResponseEntity<>(movieService.searchAllMovies(),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> removeDirector(@RequestParam String director){
        movieService.removeDirector(director);
        return new ResponseEntity<>(director + " removed successfully ",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> removeAllDirector(){
        movieService.removeAllDirector();
        return new ResponseEntity<>("All directors removed successfully", HttpStatus.CREATED);
    }
}


