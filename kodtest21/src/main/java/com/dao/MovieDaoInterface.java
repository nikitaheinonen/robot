package com.dao;

import com.model.Movie;

import java.util.List;

/**
 * Interface for movieDAO class
 */
public interface MovieDaoInterface {
    List<String> getAllTitles();
    List<String> getAllGenres();
    String getPlot(String title);
    String getLanguage(String title);
    Movie getMovie(String title);
    List<String> filterMovies(String genre, String language);
    List<Movie> searchMovie(String searchString);


}
