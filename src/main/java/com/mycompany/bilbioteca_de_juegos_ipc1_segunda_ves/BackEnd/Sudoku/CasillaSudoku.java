package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku;

public abstract class CasillaSudoku {

    protected String simbolo = " ";
    protected boolean generadoInicial;
    protected int valorDeCasilla;

    public abstract int getValorDeCasilla();

    public abstract String getSimbolo();

    public abstract boolean getGeneradoInicial();

    public abstract void setGeneradoInicial(boolean generado);
    public abstract void condicionesIniciales();

}
