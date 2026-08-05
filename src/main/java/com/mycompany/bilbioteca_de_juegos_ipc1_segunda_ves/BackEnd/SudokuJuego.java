package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.CasillaSudoku;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.NumeralVacio;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;

public class SudokuJuego {
    private InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    private BibliotecaDeDatosJuegos bibliotecaDeDatosJuegos = new BibliotecaDeDatosJuegos();
    private Scanner scanner = new Scanner(System.in);

    public void jugarSudoku() {
        CasillaSudoku[][] mapeoDeSudoku = bibliotecaDeDatosJuegos.getBaseDeDatosDeSudoku();
        interfasDeJuegos.sudoku(mapeoDeSudoku);
        scanner.nextLine();
    }

}
