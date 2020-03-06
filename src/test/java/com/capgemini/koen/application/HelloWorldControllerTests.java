package com.capgemini.koen.application;

import com.capgemini.koen.application.models.Message;
import com.capgemini.koen.application.repositories.HelloWorldRepository;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class HelloWorldControllerTests {

    @InjectMocks
    private HelloWorldController helloWorldController;

    @Mock
    private HelloWorldRepository helloWorldRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }

    @Test
    public void dummyTest() {
        assertTrue(true);
    }

    @Test
    public void testGet() throws Exception {
        List<Message> result = new ArrayList<>();

        Message message = new Message();
        message.setContent("Hi there!");
        message.setId(1L);
        result.add(message);

        when(helloWorldRepository.findAll()).thenReturn(result);

        mockMvc.perform(get("/api"))
            .andDo(print())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$.[0].id", is(1)))
            .andExpect(jsonPath("$.[0].content", is("Hi there!")))
            .andExpect(status().isOk());
    }

}
