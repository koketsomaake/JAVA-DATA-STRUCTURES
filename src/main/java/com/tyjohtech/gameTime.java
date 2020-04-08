package com.tyjohtech;

public class gameTime {

    int width;
    int height;
    int[][] board;

    public gameTime(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public void printBoard() {
        System.out.println("---");
        for (int y = 0; y < height; y++) {
            String line = "|";
            for (int x = 0; x < width; x++) {
                if (this.board[x][y] == 0) {
                    line += " +";
                } else {
                    line += " #";
                }
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("---\n");
    }

    public void setAlive(int x, int y) {
        this.board[x][y] = 1;
    }

    public void setDead(int x, int y) {
        this.board[x][y] = 0;
    }

    public int countAlive(int x, int y) {
        int count = 0;

        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return count;
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= width) {
            return 0;
        }

        if (y < 0 || y >= height) {
            return 0;
        }

        return this.board[x][y];
    }

    public void step() {
        int[][] newBoard = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int aliveBox = countAlive(x, y);

                if (getState(x, y) == 1) {
                    if (aliveBox < 2) {
                        newBoard[x][y] = 0;
                    } else if (aliveBox == 2 || aliveBox == 3) {
                        newBoard[x][y] = 1;
                    } else if (aliveBox > 3) {
                        newBoard[x][y] = 0;
                    }
                } else {
                    if (aliveBox == 3) {
                        newBoard[x][y] = 1;
                    }
                }

            }
        }

        this.board = newBoard;
    }

    public static void main(String[] args) {
        gameTime simulation = new gameTime(10, 10);

        simulation.setAlive(2, 2);
        simulation.setAlive(3, 2);
        simulation.setAlive(4, 2);

        simulation.printBoard();

        simulation.step();

        simulation.printBoard();

        simulation.step();

        simulation.printBoard();

    }

}
