package com.controller;

import com.service.DatabaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = Restcontroller.class)
@AutoConfigureMockMvc(addFilters = false)

/**
 * testclass for the controller, the endpoints
 */
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DatabaseService service;

    /**
     * test the endpoint for getting genres
     * @throws Exception
     */
    @Test
    void getGenres() throws Exception {

        List<String> genres = new ArrayList<String>();
        genres.add("Action");
        genres.add("Thriller");
        genres.add("Adventure");
        genres.add("Fantasy");
        genres.add("Crime");
        genres.add("Drama");
        genres.add("Biography");
        genres.add("History");
        genres.add("Western");
        genres.add("Romance");
        genres.add("Mystery");
        genres.add("Sci-Fi");

        when(service.getAllGenres()).thenReturn(genres);

        this.mockMvc.perform(get("/api/genres"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "[\"Action\"," +
                        "\"Thriller\"," +
                        "\"Adventure\"," +
                        "\"Fantasy\"," +
                        "\"Crime\"," +
                        "\"Drama\"," +
                        "\"Biography\"," +
                        "\"History\"," +
                        "\"Western\"," +
                        "\"Romance\"," +
                        "\"Mystery\"," +
                        "\"Sci-Fi\"]"));
    }
}
