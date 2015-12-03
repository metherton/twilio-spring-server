package com.martinetherton.twilio.server;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TaskRouterControllerTest {

    final String BASE_URL = "http://localhost:9000/";
    private MockMvc mockMvc;

    private TwimlResponseBuilder mockTwimlResponseBuilder;

    @Before
    public void setup() {
        mockTwimlResponseBuilder = Mockito.mock(TwimlResponseBuilder.class);
        this.mockMvc = standaloneSetup(new TaskRouterController(mockTwimlResponseBuilder)).build();
    }

    @Test
    public void testBasicGet() throws Exception {
        this.mockMvc.perform(get("/incoming_call")).andExpect(status().isOk());
    }

}
