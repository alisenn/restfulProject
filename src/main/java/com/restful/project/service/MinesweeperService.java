package com.restful.project.service;

import org.springframework.stereotype.Service;

import com.restful.project.exceptions.minesweeper.EmptySquareException;
import com.restful.project.exceptions.minesweeper.InvalidSquareException;
import com.restful.project.exceptions.minesweeper.NullSquareException;

@Service
public class MinesweeperService {
    
    public String[] showHints(String[] square) {
        if (square == null) {
            throw new NullSquareException("Input square cannot be null");
        }

        int rows = square.length;
        if (rows == 0) {
            throw new EmptySquareException("Input square cannot be empty");
        }

        int cols = square[0].length();
        if (cols == 0) {
            throw new EmptySquareException("Rows in input square cannot be empty");
        }
        int[][] hints = new int[rows][cols];

        for (String row : square) {
            if (row.length() != cols) {
                throw new InvalidSquareException("All rows in the square must have the same length");
            }
        }
    
        
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
