package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH;

import java.util.Random;

public class AiDeBot {
    private int filaBot = 3;
    private int columnaBot = 3;

    public void hacerMovimiento(Casilla[][] mapeoDeTicTacToe, int filaJugador, int columnaJugador) {
        filaBot = 3;
        columnaBot = 3;

        selectorDePosicion(mapeoDeTicTacToe, filaJugador, columnaJugador);

        if (filaBot == 3 || columnaBot == 3 || mapeoDeTicTacToe[filaBot][columnaBot].estaOcupada()) {
            randomizadorDeMobimiento(mapeoDeTicTacToe);
        }
    }

    private void selectorDePosicion(Casilla[][] mapeodeTicTacToe, int filaJugador, int columnaJugador) {

        int posicion;
        if (filaJugador == 0) {
            posicion = columnaJugador;
        } else {
            String union = String.valueOf(filaJugador) + String.valueOf(columnaJugador);
            posicion = Integer.parseInt(union);
        }

        switch (posicion) {
            case 0:
                // extremos caso 1
                selectorDesdeExtremos(mapeodeTicTacToe, filaJugador, columnaJugador, 1);
                break;
            case 1:
                // medios caso 1
                selectorDesdeMedios(mapeodeTicTacToe, filaJugador, columnaJugador, 1);
                break;
            case 2:
                // extremos caso 2
                selectorDesdeExtremos(mapeodeTicTacToe, filaJugador, columnaJugador, 2);
                break;
            case 10:
                // medios caso 2
                selectorDesdeMedios(mapeodeTicTacToe, filaJugador, columnaJugador, 2);
                break;
            case 11:
                selectorDesdeCentro(mapeodeTicTacToe, filaJugador, columnaJugador);
                break;
            case 12:
                // medios caso 3
                selectorDesdeMedios(mapeodeTicTacToe, filaJugador, columnaJugador, 3);
                break;
            case 20:
                // extremos caso 3
                selectorDesdeExtremos(mapeodeTicTacToe, filaJugador, columnaJugador, 3);
                break;
            case 21:
                // medios caso 4
                selectorDesdeMedios(mapeodeTicTacToe, filaJugador, columnaJugador, 4);
                break;
            case 22:
                // extremos caso 4
                selectorDesdeExtremos(mapeodeTicTacToe, filaJugador, columnaJugador, 4);
                break;
        }

    }

    private void selectorDesdeMedios(Casilla[][] mapeodeTicTacToe, int filaJugador, int columnaJugador, int caso) {
        switch (caso) {
            case 1:
                if (mapeodeTicTacToe[filaJugador + 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador + 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador + 2;
                    columnaBot = columnaJugador;
                } else if (mapeodeTicTacToe[filaJugador][columnaJugador + 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador - 1;
                } else if (mapeodeTicTacToe[filaJugador][columnaJugador - 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador + 1;
                }
                break;
            case 2:
                if (mapeodeTicTacToe[filaJugador][columnaJugador + 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador + 2;
                } else if (mapeodeTicTacToe[filaJugador - 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador - 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador + 1;
                    columnaBot = columnaJugador;
                } else if (mapeodeTicTacToe[filaJugador + 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador + 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador - 1;
                    columnaBot = columnaJugador;
                }
                break;
            case 3:
                if (mapeodeTicTacToe[filaJugador][columnaJugador - 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador - 2;
                } else if (mapeodeTicTacToe[filaJugador - 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador - 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador + 1;
                    columnaBot = columnaJugador;
                } else if (mapeodeTicTacToe[filaJugador + 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador + 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador - 1;
                    columnaBot = columnaJugador;
                }
                break;

            default:
                if (mapeodeTicTacToe[filaJugador - 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador - 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador - 2;
                    columnaBot = columnaJugador;
                } else if (mapeodeTicTacToe[filaJugador][columnaJugador + 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador - 1;
                } else if (mapeodeTicTacToe[filaJugador][columnaJugador - 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador + 1;
                }
                break;
        }
    }

    private void selectorDesdeExtremos(Casilla[][] mapeodeTicTacToe, int filaJugador, int columnaJugador, int caso) {

        switch (caso) {
            case 1:
                if (mapeodeTicTacToe[filaJugador + 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador + 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador + 2;
                    columnaBot = columnaJugador;
                } else if (mapeodeTicTacToe[filaJugador][columnaJugador + 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador + 2;
                } else if (mapeodeTicTacToe[filaJugador + 1][columnaJugador + 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador + 1][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador + 2;
                    columnaBot = columnaJugador + 2;
                }
                break;
            case 2:
                if (mapeodeTicTacToe[filaJugador + 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador + 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador + 2;
                    columnaBot = columnaJugador;
                } else if (mapeodeTicTacToe[filaJugador][columnaJugador - 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador - 2;
                } else if (mapeodeTicTacToe[filaJugador + 1][columnaJugador - 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador + 1][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador + 2;
                    columnaBot = columnaJugador - 2;
                }
                break;
            case 3:
                if (mapeodeTicTacToe[filaJugador - 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador - 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador - 2;
                    columnaBot = columnaJugador;
                } else if (mapeodeTicTacToe[filaJugador][columnaJugador + 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador + 2;
                } else if (mapeodeTicTacToe[filaJugador - 1][columnaJugador + 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador - 1][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador - 2;
                    columnaBot = columnaJugador + 2;
                }
                break;
            default:
                if (mapeodeTicTacToe[filaJugador - 1][columnaJugador].estaOcupada()
                        && mapeodeTicTacToe[filaJugador - 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador - 2;
                    columnaBot = columnaJugador;
                } else if (mapeodeTicTacToe[filaJugador][columnaJugador - 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador;
                    columnaBot = columnaJugador - 2;
                } else if (mapeodeTicTacToe[filaJugador - 1][columnaJugador - 1].estaOcupada()
                        && mapeodeTicTacToe[filaJugador - 1][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
                    filaBot = filaJugador - 2;
                    columnaBot = columnaJugador - 2;
                }
                break;
        }
    }

    private void selectorDesdeCentro(Casilla[][] mapeodeTicTacToe, int filaJugador, int columnaJugador) {

        if (mapeodeTicTacToe[filaJugador - 1][columnaJugador].estaOcupada()
                && mapeodeTicTacToe[filaJugador - 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
            filaBot = filaJugador + 1;
            columnaBot = columnaJugador;
        } else if (mapeodeTicTacToe[filaJugador + 1][columnaJugador].estaOcupada()
                && mapeodeTicTacToe[filaJugador + 1][columnaJugador].jugadorOcupando().equals("Jugador")) {
            filaBot = filaJugador - 1;
            columnaBot = columnaJugador;
        } else if (mapeodeTicTacToe[filaJugador][columnaJugador - 1].estaOcupada()
                && mapeodeTicTacToe[filaJugador][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
            filaBot = filaJugador;
            columnaBot = columnaJugador + 1;
        } else if (mapeodeTicTacToe[filaJugador][columnaJugador + 1].estaOcupada()
                && mapeodeTicTacToe[filaJugador][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
            filaBot = filaJugador;
            columnaBot = columnaJugador - 1;
        } else if (mapeodeTicTacToe[filaJugador - 1][columnaJugador - 1].estaOcupada()
                && mapeodeTicTacToe[filaJugador - 1][columnaJugador - 1].jugadorOcupando().equals("Jugador")) {
            filaBot = filaJugador + 1;
            columnaBot = columnaJugador + 1;
        } else if (mapeodeTicTacToe[filaJugador + 1][columnaJugador + 1].estaOcupada()
                && mapeodeTicTacToe[filaJugador + 1][columnaJugador + 1].jugadorOcupando().equals("Jugador")) {
            filaBot = filaJugador - 1;
            columnaBot = columnaJugador - 1;
        }

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
