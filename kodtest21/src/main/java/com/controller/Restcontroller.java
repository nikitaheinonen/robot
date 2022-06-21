package com.controller;


import com.exceptions.DatabaseConnectionException;
import com.exceptions.EmptySearchException;
import com.exceptions.NoMovieFoundException;
import com.exceptions.WrongTitleException;
import com.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * Controller for handling incoming HTTP requests.
 * A RestController does not return any views. It only handles requests and formats responses.
 * It will handle exceptions thrown by methods annotated with @RequestMapping
 */
@RestController
@CrossOrigin(origins = "*")
public class Restcontroller {

    private final DatabaseService databaseservice;

    /**
     * Constructor which instanciates a databaseservice which communicates with the dao layer which in turn communicates with the database
     * @param  databaseservice A databaseservice object
     */
    @Autowired
    public Restcontroller(DatabaseService databaseservice) {
        this.databaseservice = databaseservice;
    }


    /**
     * Endpoint to retrieve all the titles of movies frmo the database
     * @return list of titles of movies
     * @throws DatabaseConnectionException
     */
    @RequestMapping(value = "/api/titles", method = RequestMethod.GET)
    public ResponseEntity<?> getTitles() throws DatabaseConnectionException {
        return ResponseEntity.ok(databaseservice.getAllTitles());
    }

    /**
     * Endpoint for retrieving information about a single movie with the specified title
     * @param title title of the movie you want to retrieve
     * @return Movie object with all info about the movie
     * @throws WrongTitleException
     * @throws EmptySearchException
     */
    @RequestMapping(value = "/api/movie", method = RequestMethod.GET)
    public ResponseEntity<?> getMovie(@RequestParam String title) throws EmptySearchException, NoMovieFoundException {
        if(title.length() < 1){
            throw new EmptySearchException("");
        }else{
            return ResponseEntity.ok(databaseservice.getMovie(title));
        }
    }

    /**
     * Endpoint for listing all the genres
     * @return List of all available genres
     * @throws DatabaseConnectionException
     */
    @RequestMapping(value = "/api/genres", method = RequestMethod.GET)
    public ResponseEntity<?> getMovie() throws DatabaseConnectionException {
        return ResponseEntity.ok(databaseservice.getAllGenres());
    }

    /**
     * Endpoint for filtering the search with genre and language
     * @param genre desired genre
     * @param language desired language
     * @return List of movietitles that match the genre and language
     * @throws DatabaseConnectionException
     */
    @RequestMapping(value = "/api/movies/filtered", method = RequestMethod.GET)
    public ResponseEntity<?> getMovie(@RequestParam String genre, String language) throws DatabaseConnectionException {
        return ResponseEntity.ok(databaseservice.getFilteredTitles(genre, language));
    }

    /**
     * endpoint for a search consisting of a string that has either title, director, plot och actor
     * @param searchString searchstring for a movie
     * @return list of movies that match the given search string
     * @throws DatabaseConnectionException
     * @throws NoMovieFoundException
     * @throws EmptySearchException
     */
    @RequestMapping(value = "/api/movies/search", method = RequestMethod.GET)
    public ResponseEntity<?> searchMovie(@RequestParam String searchString) throws DatabaseConnectionException, NoMovieFoundException, EmptySearchException {
        if(searchString.length() < 1) {
            throw new EmptySearchException("");
        }
        return ResponseEntity.ok(databaseservice.searchMovie(searchString));
    }









}
