package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class Controller {
    @Autowired
    MovieService movieService;
    @PostMapping("/movie")
    public void addMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RuntimeException("Validation of Movie model failed...");
        }
        movieService.createMovie(movie);
    }
//    get all movies
    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovie();
    }
//    /    • GET "/ticket/movie/{id}" (@PathVariable String id)
//    : It fetches a movie by the given.
    @GetMapping("/movie/{id}")
    public Movie getMoviebyId(@PathVariable String id){
        return movieService.getMoviebyId(id);
    }
    //    • DELETE "/ticket/movie/{id}" (@PathVariable String id):
    //    It deletes a movie by the given Id.
    @DeleteMapping("/movie/{id}")
    public void deleteMoviebyID(@PathVariable String id){
        movieService.deleteMoviebyId(id);
    }

//• PUT "/ticket/update/{id}" (@Valid @RequestBody Movie topic,@PathVariable String id):
//    It updates a movie by the given Id.
    @PutMapping("/update/{id}")
    public void updateMoviebyID(@RequestBody Movie topic,@PathVariable String id){
        movieService.updateMoviebyId(topic,id);
    }

}
