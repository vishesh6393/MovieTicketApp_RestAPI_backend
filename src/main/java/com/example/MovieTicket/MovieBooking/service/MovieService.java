package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService implements MovieServiceInterface{

    List<Movie> movieList=new ArrayList<>();
    HashMap<String,Movie> movieMap=new HashMap<>();

    @Override
    public void createMovie(Movie movie) {

        if (movieMap.containsKey(movie.getId())) {
            throw new IdAlreadyExist("Movie already exist..");
        }
        movieList.add(movie);
        movieMap.put(movie.getId(), movie);
//        System.out.println("Movie id: "+movie.getId()+" name= " +movie.getMovieName()+
//                "is added successfully ");
    }

    @Override
    public Movie getMoviebyId(String id) {
        if (movieMap.containsKey(id)) {
            return movieMap.get(id);
        }
        else throw new IdNotFound("Movie Id is incorrect..");
    }
    @Override
    public List<Movie> getAllMovie() {
        return movieList;
    }
    @Override
    public void deleteMoviebyId(String id) {
        if (movieMap.containsKey(id)) {
            Movie movie = getMoviebyId(id);
            movieList.remove(movie);
            movieMap.remove(id);
        }
//        System.out.println("Removed from map and list both");
        else throw new IdNotFound("Movie Id is incorrect..");


    }
    @Override
    public void updateMoviebyId(Movie updatedMovie,String id) {
//here the updated movie json's id is given
        Movie existing_movie =getMoviebyId(id);
        if(movieList.contains(existing_movie)){
            movieList.remove(existing_movie);
            movieMap.remove(id);
            updatedMovie.setId(id);
            movieList.add(updatedMovie);
            movieMap.put(id,updatedMovie);
        }
        else{
            throw new IdNotFound("Movie id is incorrect");
        }
    }
}
