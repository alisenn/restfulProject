package com.restful.project;



import com.restful.project.controller.MinesweeperController;
import com.restful.project.service.MinesweeperService;
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

@WebMvcTest(MinesweeperController.class)
public class MinesweeperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MinesweeperService minesweeperService;

    @Test
    public void testShowHints() throws Exception {
        String[] square = {"*...", "....", ".*..", "...."};
        String[] hints = {"*100", "2210", "1*10", "1110"};
        
        when(minesweeperService.showHints(square)).thenReturn(hints);

        mockMvc.perform(post("/show-hints")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString("{\"square\": [\"*...\", \"....\", \".*..\", \"....\"]}")))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.hints[0]").value("*100"));
    }
}
