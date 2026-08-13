package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH;

public class Casilla {

    private String simbolo = " ";
    private boolean ocupada = false;
    private String jugadorOcupando = " ";

    public String estadoDeCasilla() {
        return simbolo;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public String jugadorOcupando() {
        return jugadorOcupando;
    }

    public void ocupar(String simbolo, String jugador) {
        if (!this.ocupada) {
            this.simbolo = simbolo;
            this.jugadorOcupando = jugador;
            this.ocupada = true;
        }
    }

    public void vaciar() {
        this.simbolo = " ";
        this.jugadorOcupando = " ";
        this.ocupada = false;
    }
}
