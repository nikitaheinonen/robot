package com.service;

import com.dao.MovieDao;
import com.exceptions.DatabaseConnectionException;
import com.exceptions.NoMovieFoundException;
import com.exceptions.WrongTitleException;
import com.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * Test class for the databaseservice class
 */
@SpringBootTest
public class DatabaseServiceTest {

    @Autowired
    DatabaseService service;
    @Autowired
    MovieDao movieDao;

    /**
     * test that wrong title excpetion is thrown when title is empty
     */
    @Test
    void noMovieFoundException() {

        assertThatExceptionOfType(NoMovieFoundException.class)
                .isThrownBy(() -> {
                    service.getMovie("");
                });
    }


}
