package com.restful.project;



import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.project.controller.MinesweeperController;
import com.restful.project.model.MinesweeperRequest;
import com.restful.project.service.MinesweeperService;

@WebMvcTest(MinesweeperController.class)
class MinesweeperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MinesweeperService minesweeperService;

    @Test
    void testShowHints() throws Exception {
        String[] square = {"*...", "....", ".*..", "...."};
        String[] hints = {"*100", "2210", "1*10", "1110"};
        
        when(minesweeperService.showHints(square)).thenReturn(hints);

        MinesweeperRequest request = new MinesweeperRequest();
        request.setSquare(square);

        mockMvc.perform(post("/show-hints")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.hints[0]").value("*100"));
    }
}
