package com.example.MovieTicket.MovieBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFound extends RuntimeException{
    public IdNotFound(String mssg){
        super(mssg);
    }
    public IdNotFound(){
        super();
    }
}
