package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku;

public class CasillaSudoku {

    private int valor; // 0 para vacía, 1-9 para números
    private boolean esInicial;

    public CasillaSudoku(int valorEntrante, boolean esInicialEntrante) {
        this.valor = valorEntrante;
        this.esInicial = esInicialEntrante;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (!esInicial) {
            this.valor = valor;
        }
    }

    public boolean isEsInicial() {
        return esInicial;
    }

    public String getSimbolo() {
        if (valor == 0) {
            return " ";
        }
        if (esInicial) {
            return "\033[38;5;244m" + valor + "\033[0m";
        }
        return String.valueOf(valor);
    }
}
