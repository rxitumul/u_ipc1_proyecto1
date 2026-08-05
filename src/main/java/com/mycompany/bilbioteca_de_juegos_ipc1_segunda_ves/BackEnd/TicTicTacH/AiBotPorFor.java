package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH;

import java.util.Random;

public class AiBotPorFor {
    private int filaBot = 3;
    private int columnaBot = 3;

    public void hacerMovimiento(Casilla[][] mapeoDeTicTacToe, int filaJugador, int columnaJugador) {
        filaBot = 3;
        columnaBot = 3;

        selectorDePosicion(mapeoDeTicTacToe, "Bot");
        if (filaBot == 3 && columnaBot == 3) {
            selectorDePosicion(mapeoDeTicTacToe, "Jugador");
            if (filaBot == 3 && columnaBot == 3 && !mapeoDeTicTacToe[1][1].estaOcupada()) {
                filaBot = 1;
                columnaBot = 1;
            }

            if (filaBot == 3 || columnaBot == 3 || mapeoDeTicTacToe[filaBot][columnaBot].estaOcupada()) {
                randomizadorDeMobimiento(mapeoDeTicTacToe);
            }

        }

    }

    private boolean selectorDePosicion(Casilla[][] mapeoDeTicTacToe, String jugador) {
        // Verifica las 3 filas
        for (int i = 0; i < 3; i++) {
            if (mapeoDeTicTacToe[i][0].estaOcupada() && mapeoDeTicTacToe[i][0].jugadorOcupando().equals(jugador) &&
                    mapeoDeTicTacToe[i][1].estaOcupada() && mapeoDeTicTacToe[i][1].jugadorOcupando().equals(jugador) &&
                    !mapeoDeTicTacToe[i][2].estaOcupada()) {
                filaBot = i;
                columnaBot = 2;
                return true;
            } else if (mapeoDeTicTacToe[i][1].estaOcupada() && mapeoDeTicTacToe[i][1].jugadorOcupando().equals(jugador)
                    &&
                    mapeoDeTicTacToe[i][2].estaOcupada() && mapeoDeTicTacToe[i][2].jugadorOcupando().equals(jugador) &&
                    !mapeoDeTicTacToe[i][0].estaOcupada()) {
                filaBot = i;
                columnaBot = 0;
                return true;
            } else if (mapeoDeTicTacToe[i][0].estaOcupada() && mapeoDeTicTacToe[i][0].jugadorOcupando().equals(jugador)
                    &&
                    mapeoDeTicTacToe[i][2].estaOcupada() && mapeoDeTicTacToe[i][2].jugadorOcupando().equals(jugador) &&
                    !mapeoDeTicTacToe[i][1].estaOcupada()) {
                filaBot = i;
                columnaBot = 1;
                return true;
            }
        }

        // Verifica las 3 columnas
        for (int i = 0; i < 3; i++) {
            if (mapeoDeTicTacToe[0][i].estaOcupada() && mapeoDeTicTacToe[0][i].jugadorOcupando().equals(jugador) &&
                    mapeoDeTicTacToe[1][i].estaOcupada() && mapeoDeTicTacToe[1][i].jugadorOcupando().equals(jugador) &&
                    !mapeoDeTicTacToe[2][i].estaOcupada()) {
                filaBot = 2;
                columnaBot = i;
                return true;
            } else if (mapeoDeTicTacToe[1][i].estaOcupada() && mapeoDeTicTacToe[1][i].jugadorOcupando().equals(jugador)
                    &&
                    mapeoDeTicTacToe[2][i].estaOcupada() && mapeoDeTicTacToe[2][i].jugadorOcupando().equals(jugador) &&
                    !mapeoDeTicTacToe[0][i].estaOcupada()) {
                filaBot = 0;
                columnaBot = i;
                return true;
            } else if (mapeoDeTicTacToe[0][i].estaOcupada() && mapeoDeTicTacToe[0][i].jugadorOcupando().equals(jugador)
                    &&
                    mapeoDeTicTacToe[2][i].estaOcupada() && mapeoDeTicTacToe[2][i].jugadorOcupando().equals(jugador) &&
                    !mapeoDeTicTacToe[1][i].estaOcupada()) {
                filaBot = 1;
                columnaBot = i;
                return true;
            }
        }

        // Verifica diagonal principal
        if (mapeoDeTicTacToe[0][0].estaOcupada() && mapeoDeTicTacToe[0][0].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[1][1].estaOcupada() && mapeoDeTicTacToe[1][1].jugadorOcupando().equals(jugador) &&
                !mapeoDeTicTacToe[2][2].estaOcupada()) {
            filaBot = 2;
            columnaBot = 2;
            return true;
        } else if (mapeoDeTicTacToe[1][1].estaOcupada() && mapeoDeTicTacToe[1][1].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[2][2].estaOcupada() && mapeoDeTicTacToe[2][2].jugadorOcupando().equals(jugador) &&
                !mapeoDeTicTacToe[0][0].estaOcupada()) {
            filaBot = 0;
            columnaBot = 0;
            return true;
        } else if (mapeoDeTicTacToe[0][0].estaOcupada() && mapeoDeTicTacToe[0][0].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[2][2].estaOcupada() && mapeoDeTicTacToe[2][2].jugadorOcupando().equals(jugador) &&
                !mapeoDeTicTacToe[1][1].estaOcupada()) {
            filaBot = 1;
            columnaBot = 1;
            return true;
        }

        // Verifica diagonal secundaria
        if (mapeoDeTicTacToe[0][2].estaOcupada() && mapeoDeTicTacToe[0][2].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[1][1].estaOcupada() && mapeoDeTicTacToe[1][1].jugadorOcupando().equals(jugador) &&
                !mapeoDeTicTacToe[2][0].estaOcupada()) {
            filaBot = 2;
            columnaBot = 0;
            return true;
        } else if (mapeoDeTicTacToe[1][1].estaOcupada() && mapeoDeTicTacToe[1][1].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[2][0].estaOcupada() && mapeoDeTicTacToe[2][0].jugadorOcupando().equals(jugador) &&
                !mapeoDeTicTacToe[0][2].estaOcupada()) {
            filaBot = 0;
            columnaBot = 2;
            return true;
        } else if (mapeoDeTicTacToe[0][2].estaOcupada() && mapeoDeTicTacToe[0][2].jugadorOcupando().equals(jugador) &&
                mapeoDeTicTacToe[2][0].estaOcupada() && mapeoDeTicTacToe[2][0].jugadorOcupando().equals(jugador) &&
                !mapeoDeTicTacToe[1][1].estaOcupada()) {
            filaBot = 1;
            columnaBot = 1;
            return true;
        }

        return false;
    }

    private void randomizadorDeMobimiento(Casilla[][] mapeoDeTicTacToe) {
        Random random = new Random();
        while (true) {
            filaBot = random.nextInt(3);
            columnaBot = random.nextInt(3);
            if (!mapeoDeTicTacToe[filaBot][columnaBot].estaOcupada()) {
                break;
            }
        }

    }

    public int getColumnaBot() {
        return columnaBot;
    }

    public int getFilaBot() {
        return filaBot;
    }

}
