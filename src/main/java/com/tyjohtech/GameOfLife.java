package com.tyjohtech;

public class GameOfLife {
    public static void main(String[] args)
    {
        int L = 10, A = 10;
        //0 = dead cells and 1 = live cells

        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        // looping through the grid
        System.out.println("First Generation");


        for (int i = 0; i < L; i++)
        {
            for (int j = 0; j < A; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        final boolean generation = nextGeneration(grid, L, A);
    }


    // loop for next generation
    static boolean nextGeneration(int grid[][], int L, int A)
    {
        int[][] future = new int[L][A];

        // Loop through every cell

        for (int l = 1; l < L - 1; l++)
        {
            for (int z = 1; z < A - 1; z++)
            {
                // searching number Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][z + j];

                    //subtracting a cell that was counted before
                aliveNeighbours -= grid[l][z];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((grid[l][z] == 1) && (aliveNeighbours < 2))
                    future[l][z] = 0;

                    // Cell dies due to over population
                else if ((grid[l][z] == 1) && (aliveNeighbours > 3))
                    future[l][z] = 0;

                    // A new cell is born
                else if ((grid[l][z] == 0) && (aliveNeighbours == 3))
                    future[l][z] = 1;

                    // It does not change
                else
                    future[l][z] = grid[l][z];
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < L; i++)
        {
            for (int j = 0; j < A; j++)
            {
                if (future[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        return true;
    }

}
