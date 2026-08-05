package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;

public class SudokuJuego {
    InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    BibliotecaDeDatosJuegos bibliotecaDeDatosJuegos = new BibliotecaDeDatosJuegos();

    public void jugarSudoku() {
        int[][] mapeoDeSudoku = bibliotecaDeDatosJuegos.getBaseDeDatosDeSudoku();
        interfasDeJuegos.sudoku(mapeoDeSudoku);
    }

}
