package com.service;

import com.dao.MovieDao;
import com.exceptions.DatabaseConnectionException;
import com.exceptions.NoMovieFoundException;
import com.exceptions.WrongTitleException;
import com.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Database service, handles logic and calls to the DAO
 */
@Service
public class DatabaseService {
    private final MovieDao movieDao;

    @Autowired
    public DatabaseService(@Qualifier("postgres") MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    /**
     * Get all movie titles from database
     * @return list of movietitles
     * @throws DatabaseConnectionException
     */
    public List<String> getAllTitles() throws DatabaseConnectionException {
        try{
            return movieDao.getAllTitles();
        }catch (Exception e){
            throw new DatabaseConnectionException("");
        }
    }

    /**
     * Get the titles of the movies that match the specified genre and language
     * @param genre genre of movie
     * @param language language of movie
     * @return list of titles of movies that match genre and language
     * @throws DatabaseConnectionException
     */
    public List<String> getFilteredTitles(String genre, String language) throws DatabaseConnectionException {
        try{
            return movieDao.filterMovies(genre, language);
        }catch (Exception e){
            throw new DatabaseConnectionException("");
        }
    }

    /**
     * Get all genres from database
     * @return list of genres
     * @throws DatabaseConnectionException
     */
    public List<String> getAllGenres() throws DatabaseConnectionException {
        List<String> trimmedGenres = new ArrayList<String>();
        try{
            List<String> genres = movieDao.getAllGenres();
            for(String s : genres){
                String[] split = s.split(", "); //remove duplicate genres from the result
                for(int i = 0; i < split.length; i++){
                    if(!trimmedGenres.contains(split[i])){
                        trimmedGenres.add(split[i]);
                    }
                }
            }
            return trimmedGenres;
        }catch (Exception e){
            throw new DatabaseConnectionException("");
        }
    }

    /**
     * Try to find a movie with a searchstring provided
     * @param searchString search string for a movie
     * @return list of movies matching the searchstring
     * @throws NoMovieFoundException
     * @throws DatabaseConnectionException
     */
    public List<Movie> searchMovie(String searchString) throws NoMovieFoundException, DatabaseConnectionException {
        if(movieDao.searchMovie(searchString).isEmpty()){
            throw new NoMovieFoundException("");
        }
        try{
            return movieDao.searchMovie(searchString);
        }catch (Exception e){
            throw new DatabaseConnectionException("");
        }

    }

    /**
     * Get all info of a single movie with the specified title
     * @param title of the requested movie
     * @return the whole movie object
     * @throws WrongTitleException
     */
    public Movie getMovie(String title) throws NoMovieFoundException {
        try{
            return movieDao.getMovie(title);
        }catch (Exception e){
            throw new NoMovieFoundException("");
        }
    }
}
