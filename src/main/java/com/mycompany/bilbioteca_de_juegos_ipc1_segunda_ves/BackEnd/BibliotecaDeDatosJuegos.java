package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Random;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.CasillaSudoku;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.Casilla;

public class BibliotecaDeDatosJuegos {
    private Random random = new Random();

    private CasillaSudoku[][] mapaDeSudoku = new CasillaSudoku[9][9];

    private Casilla[][] mapaInicialDeTicTacToe = new Casilla[3][3];

    public Casilla[][] getBaseDeDatosDeTicTacToe() {
        for (int i = 0; i < mapaInicialDeTicTacToe.length; i++) {
            for (int j = 0; j < mapaInicialDeTicTacToe[i].length; j++) {
                mapaInicialDeTicTacToe[i][j] = new Casilla();
            }
        }
        return mapaInicialDeTicTacToe;
    }

    public CasillaSudoku[][] getBaseDeDatosDeSudoku(int dificultad) {
        for (int i = 0; i < mapaDeSudoku.length; i++) {
            for (int j = 0; j < mapaDeSudoku[i].length; j++) {
                mapaDeSudoku[i][j] = new CasillaSudoku(0, false);
            }
        }
        creadorDeSudoku(0, 3);
        creadorDeSudoku(3, 6);
        creadorDeSudoku(6, 9);
        tableroRellenado();
        quitadorDeNumerosRandom(dificultad);
        return mapaDeSudoku;
    }

    private void creadorDeSudoku(int rangoA, int rangoB) {
        int numeroRandom;
        int[] bar = new int[9];
        for (int i = 0; i < bar.length; i++) {
            bar[i] = i + 1;
        }

        for (int i = rangoA; i < rangoB; i++) {
            for (int j = rangoA; j < rangoB; j++) {
                while (true) {
                    numeroRandom = random.nextInt(9);
                    if (bar[numeroRandom] != 0) {
                        mapaDeSudoku[i][j] = new CasillaSudoku(bar[numeroRandom], true);
                        bar[numeroRandom] = 0;
                        break;
                    }

                }
            }
        }
    }

    private boolean esValido(int fila, int columna, int num, CasillaSudoku[][] mapaDeSudokuLocal) {
        for (int i = 0; i < 9; i++) {
            if (mapaDeSudokuLocal[fila][i].getValor() == num) {
                return false;
            }
            if (mapaDeSudokuLocal[i][columna].getValor() == num) {
                return false;
            }
        }
        int inicioFila = (fila / 3) * 3;
        int inicioColumna = (columna / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mapaDeSudokuLocal[inicioFila + i][inicioColumna + j].getValor() == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean tableroRellenado() {
        for (int i = 0; i < mapaDeSudoku.length; i++) {
            for (int j = 0; j < mapaDeSudoku[i].length; j++) {
                if (mapaDeSudoku[i][j].getValor() == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (esValido(i, j, num, mapaDeSudoku)) {
                            mapaDeSudoku[i][j] = new CasillaSudoku(num, true);

                            if (tableroRellenado()) {
                                return true;
                            }

                            mapaDeSudoku[i][j] = new CasillaSudoku(0, false);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void quitadorDeNumerosRandom(int dificultad) {
        int columna;
        int fila;

        for (int i = 0; i < dificultad; i++) {
            while (true) {
                fila = random.nextInt(9);
                columna = random.nextInt(9);
                if (mapaDeSudoku[fila][columna].getValor() != 0) {
                    mapaDeSudoku[fila][columna] = new CasillaSudoku(0, false);
                    break;
                }

            }

        }
    }
}
