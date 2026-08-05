package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.Casilla;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.CasillaVacia;

public class BibliotecaDeDatosJuegos {
    private final static String[] BASE_DE_DATOS_DE_ANAGRAMAS = { "amor", "roma", "perro", "roper", "gato", "toga",
            "casa", "saca", "mesa",
            "samen" };

    private final int[][] BASE_DE_DATOS_DE_SUDOKU = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    private final Casilla[][] MAPA_INICIAL_DE_TICTACTOE= new Casilla[3][3];

    public String[] getBaseDeDatosDeAnagramas() {
        return BASE_DE_DATOS_DE_ANAGRAMAS;
    }

    public int[][] getBaseDeDatosDeSudoku() {
        return BASE_DE_DATOS_DE_SUDOKU;
    }

    public Casilla[][] getBaseDeDatosDeTicTacToe() {
        for (int i = 0; i < MAPA_INICIAL_DE_TICTACTOE.length; i++) {
            for (int j = 0; j < MAPA_INICIAL_DE_TICTACTOE[i].length; j++) {
                MAPA_INICIAL_DE_TICTACTOE[i][j] = new CasillaVacia();
            }
        }
        return MAPA_INICIAL_DE_TICTACTOE;
    }
}
