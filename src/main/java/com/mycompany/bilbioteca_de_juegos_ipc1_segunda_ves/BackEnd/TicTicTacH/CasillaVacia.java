package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH;

public class CasillaVacia extends Casilla {

    public void cambioSimbolo() {
        simbolo = " ";
        ocupada = false;
    }

    @Override
    public boolean estaOcupada() {
        return ocupada;
    }

    @Override
    public String jugadorOcupando() {
        return jugadorOcupando;
    }

}
