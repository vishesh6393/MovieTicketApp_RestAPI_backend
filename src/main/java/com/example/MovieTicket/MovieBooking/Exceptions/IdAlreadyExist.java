package com.example.MovieTicket.MovieBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdAlreadyExist extends RuntimeException{

    public IdAlreadyExist(String mssg){
        super(mssg);
    }
    public IdAlreadyExist(){
        super();
    }
}
