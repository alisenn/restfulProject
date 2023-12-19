package com.restful.project;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.project.controller.RpnController;
import com.restful.project.model.RpnRequest;
import com.restful.project.service.RpnService;

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
        String expression = "5 3 +";
        double result = 8.0;

        when(rpnService.calculate(expression)).thenReturn(result);

        RpnRequest request = new RpnRequest();
        request.setExpression(expression);

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value(result));
    }
}
