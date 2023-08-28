package com.restful.project;



import org.junit.jupiter.api.Test;

import com.restful.project.service.RpnService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpnServiceTest {

    private final RpnService rpnService = new RpnService();

    @Test
    public void testCalculate() {
        assertEquals(4, rpnService.calculate("20 5 /"), 0.0001);
        assertEquals(3, rpnService.calculate("4 2 + 3 -"), 0.0001);
        assertEquals(141, rpnService.calculate("3 5 8 * 7 + *"), 0.0001);
    }
}
