package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH;

public abstract class Casilla {

    protected String simbolo=" ";
    protected boolean ocupada = false;
    protected String jugadorOcupando = " ";

    public String estadoDeCasilla() {
        return simbolo;
    }

    public abstract void cambioSimbolo();
    public abstract boolean estaOcupada();
    public abstract String jugadorOcupando();
    

}
