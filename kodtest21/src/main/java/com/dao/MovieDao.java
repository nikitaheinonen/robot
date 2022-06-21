package com.dao;

import com.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handles the direct connection with the database
 * No logic in this class
 */
@Repository("postgres")
public class MovieDao implements MovieDaoInterface{


    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructor setting jdbcTemplate
     * @param  jdbctemplate object used for writing queries.
     */
    @Autowired
    public MovieDao(JdbcTemplate jdbctemplate){
        this.jdbcTemplate = jdbctemplate;
    }

    /**
     * Get all the titles from database that are listed as movies
     * @return list of movies
     */
    @Override
    public List<String> getAllTitles() {
        String sqlQ = "SELECT title FROM movies WHERE type = ?";
        List<String> titles = jdbcTemplate.query(
                sqlQ, new Object[] {"movie"},
                (rs, rowNum) ->
                        new String(
                                rs.getString("title")
                        )
        );
        return titles;
    }

    /**
     * Get movie titles that are in the specified genre and languge
     * @param genre genre of the movie
     * @param language language of the movie
     * @return List of titles of movies
     */
    @Override
    public List<String> filterMovies(String genre, String language) {
        String sqlQ = "SELECT * FROM movies WHERE genre ILIKE ? AND language ILIKE ?";
        List<String> filteredMovies = jdbcTemplate.query(
                sqlQ, new Object[] {"%" + genre + "%", "%" + language + "%"},
                (rs, rowNum) ->
                        new String(
                                rs.getString("title")
                        )
        );
        return filteredMovies;
    }

    /**
     * Get all genres for all movies from db
     * @return List of genres
     */
    @Override
    public List<String> getAllGenres() {
        String sqlQ = "SELECT genre FROM movies WHERE type = ?";
        List<String> genres = jdbcTemplate.query(
                sqlQ, new Object[] {"movie"},
                (rs, rowNum) ->
                        new String(
                                rs.getString("genre")
                        )
        );
        return genres;
    }

    /**
     * Get a movie by its title
     * @param title of the movie
     * @return movie object
     */
    @Override
    public Movie getMovie(String title){
        String sqlQ = "SELECT * FROM movies WHERE title ILIKE ?";
        return jdbcTemplate.queryForObject(sqlQ, new Object[]{"%" + title + "%"}, (rs, rowNum) ->
                new Movie(
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getString("rated"),
                        rs.getDate("released"),
                        rs.getString("runtime"),
                        rs.getString("genre"),
                        rs.getString("director"),
                        rs.getString("writer"),
                        rs.getString("actors"),
                        rs.getString("plot"),
                        rs.getString("language"),
                        rs.getString("country"),
                        rs.getString("awards"),
                        rs.getString("poster"),
                        rs.getString("metascore"),
                        rs.getFloat("imdbrating"),
                        rs.getInt("imdbvotes"),
                        rs.getString("imdbid")
                ));
    }



    @Override
    public String getPlot(String title) {
        return null;
    }

    /**
     * Get language for the specified movie title
     * @param title of the movie
     * @return available languages
     */
    @Override
    public String getLanguage(String title) {
        return null;
    }

    /**
     * search for a movie with a string for either title, plot, director or actor
     * @param searchString the search string
     * @return list of movie objects that match the search string
     */
    @Override
    public List<Movie> searchMovie(String searchString) {
        String sqlQ = "SELECT * FROM movies WHERE title ILIKE ? OR plot ILIKE ? " +
                "OR director ILIKE ? OR actors ILIKE ?";
        List<Movie> movies = jdbcTemplate.query(
                sqlQ, new Object[] {"%" + searchString + "%", "%" + searchString + "%",
                        "%" + searchString + "%", "%" + searchString + "%"},
                (rs, rowNum) ->
                        new Movie(
                                rs.getString("title"),
                                rs.getInt("year"),
                                rs.getString("rated"),
                                rs.getDate("released"),
                                rs.getString("runtime"),
                                rs.getString("genre"),
                                rs.getString("director"),
                                rs.getString("writer"),
                                rs.getString("actors"),
                                rs.getString("plot"),
                                rs.getString("language"),
                                rs.getString("country"),
                                rs.getString("awards"),
                                rs.getString("poster"),
                                rs.getString("metascore"),
                                rs.getFloat("imdbrating"),
                                rs.getInt("imdbvotes"),
                                rs.getString("imdbid")
                        )
        );
        return movies;
    }


}
