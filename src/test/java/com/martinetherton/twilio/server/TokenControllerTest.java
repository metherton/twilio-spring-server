package com.martinetherton.twilio.server;

import com.twilio.sdk.taskrouter.TaskRouterWorkerCapability;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by martin on 13/01/16.
 */
public class TokenControllerTest {

    final String BASE_URL = "http://localhost:9000/";
    private MockMvc mockMvc;
    private TaskRouterWorkerCapability mockTaskRouterWorkerCapability;

    @Before
    public void setup() {
        mockTaskRouterWorkerCapability = Mockito.mock(TaskRouterWorkerCapability.class);
        this.mockMvc = standaloneSetup(new TokenController(mockTaskRouterWorkerCapability)).build();
    }

    @Test
    public void testBasicGet() throws Exception {
        Mockito.when(mockTaskRouterWorkerCapability.generateToken()).thenReturn("123");
        this.mockMvc.perform(get("/agents")).andExpect(status().isOk()).andExpect(jsonPath("workerToken").value("123"));
        Mockito.verify(mockTaskRouterWorkerCapability).generateToken();
    }


}
