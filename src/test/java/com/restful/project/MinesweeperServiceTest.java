package com.restful.project;



import org.junit.jupiter.api.Test;

import com.restful.project.service.MinesweeperService;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinesweeperServiceTest {

    private final MinesweeperService minesweeperService = new MinesweeperService();

    @Test
    public void testShowHints() {
        assertArrayEquals(new String[] {"*100", "2210", "1*10", "1110"}, 
                          minesweeperService.showHints(new String[] {"*...", "....", ".*..", "...."}));
    }
}
