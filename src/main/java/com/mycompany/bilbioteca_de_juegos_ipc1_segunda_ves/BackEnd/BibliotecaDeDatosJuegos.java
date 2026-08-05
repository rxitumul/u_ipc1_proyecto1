package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Random;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.CasillaSudoku;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral1;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral2;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral3;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral4;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral5;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral6;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral7;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral8;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.Numeral9;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.NumeralVacio;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.Casilla;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.CasillaVacia;

public class BibliotecaDeDatosJuegos {
    private final static String[] BASE_DE_DATOS_DE_ANAGRAMAS = { "amor", "roma", "perro", "roper", "gato", "toga",
            "casa", "saca", "mesa",
            "samen" };

    private CasillaSudoku[][] mapaDeSudoku = new CasillaSudoku[9][9];

    private Casilla[][] mapaInicialDeTicTacToe = new Casilla[3][3];

    public String[] getBaseDeDatosDeAnagramas() {
        return BASE_DE_DATOS_DE_ANAGRAMAS;
    }

    public Casilla[][] getBaseDeDatosDeTicTacToe() {
        for (int i = 0; i < mapaInicialDeTicTacToe.length; i++) {
            for (int j = 0; j < mapaInicialDeTicTacToe[i].length; j++) {
                mapaInicialDeTicTacToe[i][j] = new CasillaVacia();
            }
        }
        return mapaInicialDeTicTacToe;
    }

    public CasillaSudoku[][] getBaseDeDatosDeSudoku() {
        for (int i = 0; i < mapaDeSudoku.length; i++) {
            for (int j = 0; j < mapaDeSudoku[i].length; j++) {
                mapaDeSudoku[i][j] = new NumeralVacio();
            }
        }
        creadorDeSudoku(0, 3);
        creadorDeSudoku(3, 6);
        creadorDeSudoku(6, 9);

        return mapaDeSudoku;
    }

    private void creadorDeSudoku(int rangoA, int rangoB) {
        Random random = new Random();
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
                        mapaDeSudoku[i][j] = tablaDeNumeros(bar[numeroRandom]);
                        mapaDeSudoku[i][j].setGeneradoInicial(true);
                        mapaDeSudoku[i][j].condicionesIniciales();
                        bar[numeroRandom] = 0;
                        break;
                    }

                }
            }
        }
    }

    private CasillaSudoku tablaDeNumeros(int tipo) {
        switch (tipo) {
            case 1:
                return new Numeral1();
            case 2:
                return new Numeral2();
            case 3:
                return new Numeral3();
            case 4:
                return new Numeral4();
            case 5:
                return new Numeral5();
            case 6:
                return new Numeral6();
            case 7:
                return new Numeral7();
            case 8:
                return new Numeral8();
            default:
                return new Numeral9();
        }
    }
}
