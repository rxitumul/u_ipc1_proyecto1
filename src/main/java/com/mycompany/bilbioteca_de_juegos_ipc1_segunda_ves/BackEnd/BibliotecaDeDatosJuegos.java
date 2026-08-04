package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

public class BibliotecaDeDatosJuegos {
    private final static String[] BASE_DE_DATOS_DE_ANAGRAMAS = { "amor", "roma", "perro", "roper", "gato", "toga",
            "casa", "saca", "mesa",
            "samen" };

    private final int[][] BASE_DE_DATOS_DE_SUDOKU = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    private final int[][] BASE_DE_DATOS_DE_TICTACTOE = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

    public String[] getBaseDeDatosDeAnagramas() {
        return BASE_DE_DATOS_DE_ANAGRAMAS;
    }

    public int[][] getBaseDeDatosDeSudoku() {
        return BASE_DE_DATOS_DE_SUDOKU;
    }

    public int[][] getBaseDeDatosDeTicTacToe() {
        return BASE_DE_DATOS_DE_TICTACTOE;
    }
}
