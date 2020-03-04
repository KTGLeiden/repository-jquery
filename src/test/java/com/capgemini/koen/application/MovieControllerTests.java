package com.capgemini.koen.application;

import com.capgemini.koen.application.controllers.MovieController;
import com.capgemini.koen.application.models.Movie;
import com.capgemini.koen.application.repositories.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MovieControllerTests {

    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieRepository movieRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }

//    @Test
//    public void addingMovieApiTest() throws Exception {
//        Movie movie = new Movie(1L, "testtitle", 9, 1999);
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(mapper);
//
//        when(movieRepository.save(Mockito.any(Movie.class))).thenReturn(movie);
//
//        this.mockMvc.perform(post("/api/movies")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(json))
//                .andDo(print())
//                .andExpect(jsonPath("$.id"), is((int)movie.getId()));
//    }
}
