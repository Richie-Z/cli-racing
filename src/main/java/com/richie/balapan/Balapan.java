/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richie.balapan;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Richie-PC
 */
public class Balapan {

    private static final byte MAP_LENGTH = 20;
    static char[][] mapRace = new char[MAP_LENGTH][MAP_LENGTH];
    private static final byte X = 18;
    private static byte x1 = X, x2 = X;
    private static final byte Y1 = 5, Y2 = 10;
    private static final char PLAYER = 'O';

    private static void generateMap() {
        for (int i = 0; i < MAP_LENGTH; i++) {
            for (int j = 0; j < MAP_LENGTH; j++) {
                mapRace[i][j] = ' ';
            }
        }
        mapRace[X][Y1] = PLAYER;
        mapRace[X][Y2] = PLAYER;
    }

    private static void printMap() {
        for (int i = 0; i < MAP_LENGTH; i++) {
            for (int j = 0; j < MAP_LENGTH; j++) {
                System.out.print(mapRace[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        generateMap();
        printMap();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (x1 == 0 || x2 == 0) {
                System.out.println(x1 == 0 ? "Player 1 Win" : "Player 2 Win");
                break;
            }
            String input = scanner.nextLine();
            switch (input) {
                case "w":
                    mapRace[x1][Y1] = ' ';
                    x1--;
                    mapRace[x1][Y1] = PLAYER;
                    printMap();
                    break;
                case "o":
                    mapRace[x2][Y2] = ' ';
                    x2--;
                    mapRace[x2][Y2] = PLAYER;
                    printMap();
                    break;
                default:
                    System.out.println("no");
            }
        }
    }
}
