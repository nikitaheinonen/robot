package com.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Testclass for the DAO
 */
@SpringBootTest
public class MovieDaoTest {

    @Autowired MovieDao movieDao;

    /**
     * test that all titles returned are expected
     */
    @Test
    void getAllTitles(){

        //expected
        List<String> titles = new ArrayList<String>();
        titles.add("Die Hard");
        titles.add("Avatar");
        titles.add("The Godfather");
        titles.add("The Shawshank Redemption");
        titles.add("The Dark Knight");
        titles.add("Pulp Fiction");
        titles.add("Schindler's List");
        titles.add("12 Angry Men");
        titles.add("The Good, the Bad and the Ugly");
        titles.add("The Lord of the Rings: The Return of the King");
        titles.add("Fight Club");
        titles.add("The Lord of the Rings: The Fellowship of the Ring");
        titles.add("Star Wars: Episode V - The Empire Strikes Back");
        titles.add("Forrest Gump");
        titles.add("Inception");
        titles.add("One Flew Over the Cuckoo's Nest");
        titles.add("The Lord of the Rings: The Two Towers");
        titles.add("Goodfellas");
        titles.add("The Matrix");
        titles.add("Star Wars: Episode IV - A New Hope");
        titles.add("Interstellar");

        List<String> result = movieDao.getAllTitles();
        assertThat(result).isEqualTo(titles);

    }

}
