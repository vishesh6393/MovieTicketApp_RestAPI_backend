package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieServiceInterface {
    public void createMovie(Movie movie);
    public Movie getMoviebyId(String id);

    public List<Movie> getAllMovie();

    public void deleteMoviebyId(String id);


   public void updateMoviebyId( Movie updatedMovie,String id);
}
