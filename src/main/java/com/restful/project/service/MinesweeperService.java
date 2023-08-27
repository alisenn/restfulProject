package com.restful.project.service;

import org.springframework.stereotype.Service;

@Service
public class MinesweeperService {
    
    public String[] showHints(String[] square) {
        int rows = square.length;
        int cols = square[0].length();
        int[][] hints = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (square[i].charAt(j) == '*') {
                    // Update adjacent squares
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int x = i + dx, y = j + dy;
                            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                                hints[x][y]++;
                            }
                        }
                    }
                }
            }
        }
        
        String[] result = new String[rows];
        for (int i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                if (square[i].charAt(j) == '*') {
                    sb.append('*');
                } else {
                    sb.append(hints[i][j]);
                }
            }
            result[i] = sb.toString();
        }
        
        return result;
    }
}
