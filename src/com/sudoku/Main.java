package com.sudoku; //If you just copied my code, change the package to your pathway of the file (good english)

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
        int delNumber = 9; //The user enters the number here



        //Generate board
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                boolean clearRow;
                boolean clearColumn;
                boolean clearQuad = false;

                //Generated number
                int genNumber = random.nextInt(4) + 1;

                //This looks up what quad genNumber currently is in
                if (x < 2 && y < 2) {
                    identifiedQuad = 1;
                } else if (x > 1 && y < 2) {
                    identifiedQuad = 2;
                } else if (x < 2 && y > 1) {
                    identifiedQuad = 3;
                } else if (x > 1 && y > 1) {
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



//                    if (enter < 3) {
//
//                        if (enter == 2) {
//                            //  System.out.print("|");
//                        }
//                        if (ASCIIcounter == 2) {
//                            //  System.out.print("-----");
//                            ASCIIcounter = 0;
//                            // System.out.println();
//                        }
//
//                        enter++;
//                    } else {
//                        //System.out.println(board5[x][y]);
//                        enter = 0;
//                        ASCIIcounter = ASCIIcounter + 1;
//                    }
                } else {
                    x--;
                    failCounter = failCounter + 1;
                    if (failCounter > 250) {
                        board5 = new int[4][4];
                        y = 0;
                        x = -1;
                        failCounter = 0;
                        System.out.println();
                        System.out.println("FAILED TO GENERATE SUDOKU. RETRYING:");
                        System.out.println();

                    }
                }
                //Här kan du köra test kod Sebastian. Tack Sebastian.
            }
        }


        //Remove stuff


        //The switch i guess
        for (delEffect = 0; delEffect < delNumber; delEffect++) {

            int randomX = random.nextInt(4);
            int randomY = random.nextInt(4);

            board5[randomX][randomY] = 0;


        }

//
//        //Print shit
//
//
//        //enter makes the program go down a step after 4 numbers. Otherwise it would not be rendered as a sudoku, but just a single line

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

    }

        public static boolean checkQuad(int[] quadx, int genNumber) {

            return quadx[0] != genNumber && quadx[1] != genNumber && quadx[2] != genNumber && quadx[3] != genNumber;

        }








            /*reseta X och Y för att sedan göra en counter så att du kan printa alla koordinater
            Gör ett typ delete-amount. Genom detta kan användaren ta bort ett specifierat amount med rutor som förändrar svårighetgraden.
            Gör sedan typ (switch eller något. Du ska byta ut det till 0) sedan ett random nummer för x och ett random för y. Det ska utföras så många gånger som delete-amount är satt till
            Utför sedan print. Och det bör vara klart.
*/
            //Exempel kod:


            //Print the fuckin board
//            for (int printCounter = 0; printCounter < 16; printCounter++) {
//
//                enter = 0;
//                ASCIIcounter = 0;
//
//                if (enter < 3) {
//
//                    if (enter == 2) {
//                        System.out.print("|");
//                    }
//                    if (ASCIIcounter == 2) {
//                        System.out.print("-----");
//                        ASCIIcounter = 0;
//                        System.out.println();
//                    }
//                    //vanlig print
//                    System.out.print(board5[x][y]);
//                    enter++;
//
//                } else {
//
//                }            //Printar ut en linje ner här
//                System.out.println(board5[x][y]);
//                enter = 0;
//                ASCIIcounter = ASCIIcounter + 1;
//            }






//        int delNumber = 9;
//        x = 0 && y = 0;
//        int delEffect = 0;
//
//        //The switch i guess
//        for (int delEffect; delEffect < delNumber; delEffect++) {
//
//            int randomX = random.nextInt(4);
//            int randomY = random.nextInt(4);
//
//            board5[randomX][randomY] = 0;
//        }
//    }

}