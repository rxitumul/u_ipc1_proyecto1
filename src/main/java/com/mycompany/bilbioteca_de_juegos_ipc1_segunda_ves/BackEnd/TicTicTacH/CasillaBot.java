package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH;

public class CasillaBot extends Casilla {

    public void cambioSimbolo() {
        simbolo = "\033[34mO\033[0m";
        ocupada = true;
        jugadorOcupando = "Bot";
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
