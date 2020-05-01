package com.capgemini.koen.application;

import com.capgemini.koen.application.controllers.MovieController;
import com.capgemini.koen.application.models.Movie;
import com.capgemini.koen.application.repositories.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

    @Test

    public void testAddMovie() throws Exception {
        Movie movie = new Movie(1398L, "Test title", 9, 1999);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(movie);

        when(movieRepository.save(Mockito.any(Movie.class)))
                .thenReturn(movie);

        this.mockMvc.perform(post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id", is(movie.getId().intValue())))
                .andExpect(jsonPath("$.title", is(movie.getTitle())))
                .andExpect(status().isOk());

        verify(movieRepository, times(1)).save(Mockito.any(Movie.class));
    }


    @Test
    public void gettingMovieApiTest() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1L, "testtitle", 9, 1999));
        movies.add(new Movie(2L, "test2title", 10, 2000));

        when(movieRepository.findAll()).thenReturn(movies);

        this.mockMvc.perform(get("/api/movies"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(status().isOk());

        Mockito.verify(movieRepository, times(1)).findAll();
    }
}
