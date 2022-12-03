package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie,String director){
        movieRepository.saveMovieDirectorPair(movie,director);
    }

    public Movie searchMovie(String movie){
        return movieRepository.findMovie(movie);
    }

    public Director searchDirector(String director){
        return movieRepository.findDirector(director);
    }

    public List<String> searchMovieFromDirector(String director){
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> searchAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void removeDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void removeAllDirector(){
        movieRepository.deleteAllDirector();
    }
}
