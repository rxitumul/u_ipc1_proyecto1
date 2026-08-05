package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH;

public class CasillaJugador extends Casilla {
    public void cambioSimbolo() {
        simbolo = "\033[31mX\033[0m";
        ocupada = true;
        jugadorOcupando = "Jugador";
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
