package com.sudoku; //If you just copied my code, change the package to your pathway of the file. If you're on a web compiler, or something like that, remove this line.

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int failCounter = 0;
        int identifiedQuad = 0;
        int[][] board5 = new int[4][4];
        int enter = 0;
        int ASCIIcounter = 0;
        int delEffect;

        //LOOK OVER HERE

        int delNumber = 9; //Enter the number here. The higher the number, the harder the puzzle. Remember: MAX 14. 16 Will print out only zeros.

        //LOOK OVER HERE

        //This generates the board
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                boolean clearRow;
                boolean clearColumn;
                boolean clearQuad;

                //Generated number
                int genNumber = random.nextInt(4) + 1;

                //This looks up what quad genNumber currently is in
                if (x < 2 && y < 2) {
                    identifiedQuad = 1;
                } else if (x > 1 && y < 2) {
                    identifiedQuad = 2;
                } else if (x < 2) {
                    identifiedQuad = 3;
                } else {
                    identifiedQuad = 4;
                }

                //This is where the 4 quads are defined
                int[] quad1 = new int[4];
                quad1[0] = board5[0][0];
                quad1[1] = board5[0][1];
                quad1[2] = board5[1][0];
                quad1[3] = board5[1][1];

                int[] quad2 = new int[4];
                quad2[0] = board5[2][0];
                quad2[1] = board5[2][1];
                quad2[2] = board5[3][0];
                quad2[3] = board5[3][1];

                int[] quad3 = new int[4];
                quad3[0] = board5[0][2];
                quad3[1] = board5[0][3];
                quad3[2] = board5[1][2];
                quad3[3] = board5[1][3];

                int[] quad4 = new int[4];
                quad4[0] = board5[2][2];
                quad4[1] = board5[2][3];
                quad4[2] = board5[3][2];
                quad4[3] = board5[3][3];

                //This takes the quad that genNumber is in and checks if it has the number that genNumber produced
                if (identifiedQuad == 1) {
                    clearQuad = checkQuad(quad1, genNumber);
                } else if (identifiedQuad == 2) {
                    clearQuad = checkQuad(quad2, genNumber);
                } else if (identifiedQuad == 3) {
                    clearQuad = checkQuad(quad3, genNumber);
                } else {
                    clearQuad = checkQuad(quad4, genNumber);
                }

                //This is the rules that check if the X and Y axis is clear from the generated number
                clearRow = (genNumber != board5[(x + 1) % 4][y] && genNumber != board5[(x + 2) % 4][y] && genNumber != board5[(x + 3) % 4][y]);
                clearColumn = (genNumber != board5[x][(y + 1) % 4] && genNumber != board5[x][(y + 2) % 4] && genNumber != board5[x][(y + 3) % 4]);

                //This is true if both the x axis, y axis, and quad is clear from the generated number
                if (clearRow && clearColumn && clearQuad) {
                    board5[x][y] = genNumber;
                } else {
                    x--;
                    failCounter = failCounter + 1;
                    if (failCounter > 250) {
                        board5 = new int[4][4];
                        y = 0;
                        x = -1;
                        failCounter = 0;
                    }
                }
            }
        }

        //This is the function where it coverts random coordinates to 0
        for (delEffect = 0; delEffect < delNumber; delEffect++) {

            int randomX = random.nextInt(4);
            int randomY = random.nextInt(4);

            if (board5[randomX][randomY] == 0) {
                 delEffect--;
            } else {
                board5[randomX][randomY] = 0;
            }
        }

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (enter < 3) {

                    if (enter == 2) {
                        System.out.print("|");
                    }
                    if (ASCIIcounter == 2) {
                        System.out.print("-----");
                        ASCIIcounter = 0;
                        System.out.println();
                    }
                    System.out.print(board5[x][y]);
                    enter++;
                } else {
                    System.out.println(board5[x][y]);
                    enter = 0;
                    ASCIIcounter = ASCIIcounter + 1;
                }
            }
        }
        System.out.println();
        System.out.print("BOARD PRINTED. GOOD LUCK SOLVING IT!");
    }

    private static boolean checkQuad(int[] quadx, int genNumber) {

        return quadx[0] != genNumber && quadx[1] != genNumber && quadx[2] != genNumber && quadx[3] != genNumber;

    }
}

/*
As this is my first project in Java ever, the code might be wrongly formatted.
I've learnt all this in just one week. I've never coded in Java before.
Code made by Sebastian (IxyR4).
Special thanks to Kevin and Nicholas for the amazing help creating this.
Huge thanks to HiQ for giving me this task, i'm looking forward for more.
*/