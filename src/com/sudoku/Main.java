package com.sudoku;

import javax.sound.midi.SysexMessage;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int failCounter = 0;
        int enter = 0;
        int[][] board5 = new int[4][4];

        /*int [] board =  new int[4];
        int [] board2 = new int[4];
        int [] board3 = new int[4];
        int [] board4 = new int[4];
        */
        //int test = random.nextInt(4) + 1;
        // int [x][y] board5

        //int validNumber = 0;

        //Setup


//        while (c < 4) {
//            board5[x%4][y] = random.nextInt(4) + 1;
//            int modolunumber = 4;
//
//            //Kom iåg modulus och sådana saker. Kolla dina papper
//
//            modolunumber = modolunumber % 4;

            for(int y = 0; y < 4; y++) {
                for(int x = 0; x < 4; x++) {
                    boolean clearRow;
                    boolean clearColumn;
                    boolean clearQuad = false;
                    int genNumber = random.nextInt(4) + 1;
                    int identifiedQuad = 0;

                    //Du ska få genNumber ska identidiera vilken quad den ligger i. Det värdet ska läggas i identifiedQuad.
                    //Ideer om hur du ska göra. Den som tjuvtittar på min kod. Plez look here and halp me plez

                    // if x && y = what
                    //Det är inte genNumber. Det ska vara board med IdentifiedQuad ett if eller switch statement
                    //Ta x och y och kolla passar dessa med quad1, 2, 3, 4.

                    //This is the example code for identifiedQuad. It defines what quad the genNumber is in.
                    if (x < 2 && y < 2) {
                    identifiedQuad = 1;
                    } else if (x > 1 && y < 2) {
                    identifiedQuad = 2;
                    } else if (x < 2 && y > 1) {
                    identifiedQuad = 3;
                    } else if (x > 1 && y > 1) {
                    identifiedQuad = 4;
                    }



                    //quads coming ovah here boye
                    int[] quad1 = new int [4];
                    quad1[0] = board5[0][0];
                    quad1[1] = board5[0][1];
                    quad1[2] = board5[1][0];
                    quad1[3] = board5[1][1];

                    int[] quad2 = new int [4];
                    quad2[0] = board5[2][0];
                    quad2[1] = board5[2][1];
                    quad2[2] = board5[3][0];
                    quad2[3] = board5[3][1];

                    int[] quad3 = new int [4];
                    quad3[0] = board5[0][2];
                    quad3[1] = board5[0][3];
                    quad3[2] = board5[1][2];
                    quad3[3] = board5[1][3];

                    int[] quad4 = new int [4];
                    quad4[0] = board5[2][2];
                    quad4[1] = board5[2][3];
                    quad4[2] = board5[3][2];
                    quad4[3] = board5[3][3];

                    if(identifiedQuad == 1) {
                        clearQuad = checkQuad(quad1, genNumber);
                    } else if(identifiedQuad == 2) {
                        clearQuad = checkQuad(quad2, genNumber);
                    } else if(identifiedQuad == 3) {
                        clearQuad = checkQuad(quad3, genNumber);
                    } else if(identifiedQuad == 4) {
                        clearQuad = checkQuad(quad4, genNumber);
                    }

                    clearRow = (genNumber != board5[(x+1)%4][y] && genNumber != board5[(x+2)%4][y] && genNumber != board5[(x+3)%4][y]);//Kolla om next number inte e samma sak som (koordinater)
                    clearColumn = (genNumber != board5[x][(y+1)%4] && genNumber != board5[x][(y+2)%4] && genNumber != board5[x][(y+3)%4]);

                    if (clearRow && clearColumn && clearQuad) {
                        board5[x][y] = genNumber;
                        if (enter < 3) {

                            System.out.print(board5[x][y]);
                            enter++;
                        } else {
                            System.out.println(board5[x][y]);
                            enter = 0;
                        }
                    } else {
                        x--;
                        failCounter = failCounter + 1;
                        if (failCounter > 250) {
                            board5 = new int[4][4];
                            y = 0;
                            x = -1;
                            enter = 0;
                            failCounter = 0;
                            System.out.println();
                            System.out.println();
                        }
                    }
                     /*System.out.print(clearRow);
                    System.out.print(genNumber);
                    System.out.print(" ");
                    */

                    //X checker and later Y checker
                    //How do you check what's a valid number???

                }
            }
//                else {
//                    System.out.print(board5[x][y]);  //This makes the first cell filled with something
//
//                x = x + 1;
//                c = c + 1;
//
//            }
        }
        public static boolean checkQuad (int[] quadx, int genNumber) {

        if (quadx[0] == genNumber || quadx[1] == genNumber || quadx[2] == genNumber || quadx[3] == genNumber) {
            return false;
        } else {
            return true;
        }

        }

    }


    //Du ska få genNumber ska identidiera vilken quad den ligger i. Det värdet ska läggas i identifiedQuad.
//Efteråt har du ASCII kvar good luck m9!
//Lycka till du har inte Nicholas. gg wp get rekt nub.

