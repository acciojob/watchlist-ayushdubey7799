package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> createMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        movieService.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> findMovie(@PathVariable String name) {
        return new ResponseEntity<>(movieService.findMovie(name), HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> findDirector(@PathVariable String name){
        return new ResponseEntity<>(movieService.findDirector(name),HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> findMovieFromDirector(@PathVariable String director){
        return new ResponseEntity<>(movieService.findMoviesFromDirector(director),HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirector(@RequestParam String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director + " removed successfully ",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirector(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("All directors removed successfully", HttpStatus.CREATED);
    }
}


