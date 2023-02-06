package com.movie.api.app.movie.api.application.controller;

import com.movie.api.app.movie.api.application.model.Movie;
import com.movie.api.app.movie.api.application.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping()
    public ResponseEntity<List<Movie>> allMovies(){
        List<Movie> svc = movieService.getAllMovies();
        return new ResponseEntity<List<Movie>>(svc, HttpStatus.OK);
    }
    @GetMapping("/movie/{id}")
    public ResponseEntity<Optional<Movie>> retMovie(@PathVariable ObjectId id){

        Optional movieInfo = movieService.retrieveMovie(id);
        return new ResponseEntity<Optional<Movie>>(movieInfo, HttpStatus.OK);
    }
    @GetMapping("/imdbId/{imdbId}")
    public ResponseEntity<Optional<Movie>> retrieveMovieImdb(@PathVariable String imdbId){
        Optional  mImdbid = movieService.retMovieByImdbId(imdbId); 
        return new ResponseEntity<Optional<Movie>>(mImdbid, HttpStatus.OK);
    }

}
