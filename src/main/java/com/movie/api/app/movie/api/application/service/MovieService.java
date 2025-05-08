package com.movie.api.app.movie.api.application.service;

import com.movie.api.app.movie.api.application.model.Movie;
import com.movie.api.app.movie.api.application.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class MovieService {

    private final MovieRepository movieRepository;
    
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        List<Movie> allMovies = movieRepository.findAll();
        return allMovies;
    }

    public Optional<Movie> retrieveMovie(ObjectId id){
        Optional<Movie> movieList = movieRepository.findById(id);
        return movieList;
    }
    public Optional<Movie> retMovieByImdbId(String imdbId){

        Optional<Movie> genImdbId = movieRepository.findBMovieByImdbId(imdbId);
        return genImdbId;
    }

}
