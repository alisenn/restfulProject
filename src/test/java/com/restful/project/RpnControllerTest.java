package com.restful.project;

import com.restful.project.controller.RpnController;
import com.restful.project.service.RpnService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;

@WebMvcTest(RpnController.class)
public class RpnControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RpnService rpnService;

    @Test
    public void testCalculate() throws Exception {
        when(rpnService.calculate("20 5 /")).thenReturn(4.0);
        
        mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString("{\"expression\":\"20 5 /\"}")))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.result").value(4.0));
    }
}
