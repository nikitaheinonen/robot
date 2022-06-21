package com.advice;

import com.exceptions.DatabaseConnectionException;
import com.exceptions.EmptySearchException;
import com.exceptions.NoMovieFoundException;
import com.exceptions.WrongTitleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {


    @ExceptionHandler(value = {DatabaseConnectionException.class})
    public ResponseEntity<String> databaseConnectionException(DatabaseConnectionException e){
        return new ResponseEntity<String>("Could not connect to database", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {WrongTitleException.class})
    public ResponseEntity<String> wrongTitleException(WrongTitleException e){
        return new ResponseEntity<String>("Could not find a movie with this title", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NoMovieFoundException.class})
    public ResponseEntity<String> movieNotFoundException(NoMovieFoundException e){
        return new ResponseEntity<String>("Could not find a movie related to this search", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EmptySearchException.class})
    public ResponseEntity<String> emptySearchException(EmptySearchException e){
        return new ResponseEntity<String>("No data entered in search", HttpStatus.BAD_REQUEST);
    }

}
