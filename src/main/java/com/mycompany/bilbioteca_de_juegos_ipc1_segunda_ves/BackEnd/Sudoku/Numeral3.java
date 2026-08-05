package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku;

public class Numeral3 extends CasillaSudoku{
 @Override
    public int getValorDeCasilla() {
        return valorDeCasilla;
    }

    @Override
    public String getSimbolo() {
        return simbolo;
    }

    @Override
    public boolean getGeneradoInicial() {
        return generadoInicial;
    }

    @Override
    public void setGeneradoInicial(boolean generadoEntrante) {

        generadoInicial = generadoEntrante;

    }
        @Override
    public void condicionesIniciales() {
        if (generadoInicial) {
            simbolo = "\033[38;5;244m3\033[0m";
        } else {
            simbolo = "3";
        }
        valorDeCasilla = 3;
    }
}
