package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.InterfasDeJuegos;

public class TicTicTac {

    InterfasDeJuegos interfasDeJuegos = new InterfasDeJuegos();
    BibliotecaDeDatosJuegos bibliotecaDeDatosJuegos = new BibliotecaDeDatosJuegos();

    public void jugarTicTacToe() {
        int[][] mapeoDeTicTacToe = bibliotecaDeDatosJuegos.getBaseDeDatosDeTicTacToe();
        interfasDeJuegos.ticTacToe(mapeoDeTicTacToe,"0");
    }

}
