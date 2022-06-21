package com.advice;

import com.exceptions.DatabaseConnectionException;
import com.exceptions.EmptySearchException;
import com.exceptions.NoMovieFoundException;
import com.exceptions.WrongTitleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Advice class for handling exceptions frmo controller
 */
@ControllerAdvice
public class RestControllerAdvice {

    /**
     * Exception for when database is not connected for some reason
     * @param e exception
     * @return response entity
     */
    @ExceptionHandler(value = {DatabaseConnectionException.class})
    public ResponseEntity<String> databaseConnectionException(DatabaseConnectionException e){
        return new ResponseEntity<String>("Could not connect to database", HttpStatus.BAD_REQUEST);
    }

    /**
     * Exeption for when the title is empty
     * @param e exception
     * @return resposne entity with http code
     */
    @ExceptionHandler(value = {WrongTitleException.class})
    public ResponseEntity<String> wrongTitleException(WrongTitleException e){
        return new ResponseEntity<String>("Could not find a movie with this title", HttpStatus.BAD_REQUEST);
    }

    /**
     * exception for when no movie was found
     * @param e exception
     * @return response entity with http code
     */
    @ExceptionHandler(value = {NoMovieFoundException.class})
    public ResponseEntity<String> movieNotFoundException(NoMovieFoundException e){
        return new ResponseEntity<String>("Could not find a movie related to this search", HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception for when the search is empty
     * @param e exception
     * @return response entity with http code
     */
    @ExceptionHandler(value = {EmptySearchException.class})
    public ResponseEntity<String> emptySearchException(EmptySearchException e){
        return new ResponseEntity<String>("No data entered in search", HttpStatus.BAD_REQUEST);
    }

}
