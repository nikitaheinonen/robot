package com.model;

import java.util.Date;

/**
 * A Movie class with all the fields included in the movie
 */
public class Movie {
    protected String title;
    protected int year;
    protected String rated;
    protected Date released;
    protected String runtime;
    protected String genre;
    protected String director;
    protected String writer;
    protected String actors;
    protected String plot;
    protected String language;
    protected String country;
    protected String awards;
    protected String poster;
    protected String metaScore;
    protected float imdbScore;
    protected int imdbVotes;
    protected String imdbId;

    /**
     * Constructor for movie class
     * @param title title
     * @param year year
     * @param rated rated
     * @param released released
     * @param runtime runtime
     * @param genre genre
     * @param director director
     * @param writer writer
     * @param actors actors
     * @param plot plot
     * @param language language
     * @param country country
     * @param awards awards
     * @param poster poster
     * @param metaScore metascore
     * @param imdbScore imdbscore
     * @param imdbVotes imdbvotes
     * @param imdbId imdbid
     */
    public Movie(String title, int year, String rated,
                 Date released, String runtime, String genre,
                 String director, String writer, String actors,
                 String plot, String language, String country,
                 String awards, String poster, String metaScore,
                 float imdbScore, int imdbVotes, String imdbId) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.metaScore = metaScore;
        this.imdbScore = imdbScore;
        this.imdbVotes = imdbVotes;
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String getRated() {
        return this.rated;
    }

    public Date getReleased() {
        return this.released;
    }

    public String getRuntime() {
        return this.runtime;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getDirector() {
        return this.director;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getActors() {
        return this.actors;
    }

    public String getPlot() {
        return this.plot;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCountry() {
        return this.country;
    }

    public String getAwards() {
        return this.awards;
    }

    public String getPoster() {
        return this.poster;
    }

    public String getMetaScore() {
        return this.metaScore;
    }

    public float getImdbScore() {
        return this.imdbScore;
    }

    public int getImdbVotes() {
        return this.imdbVotes;
    }

    public String getImdbId() {
        return this.imdbId;
    }
}
