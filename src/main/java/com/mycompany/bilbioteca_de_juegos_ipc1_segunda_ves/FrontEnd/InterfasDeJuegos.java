package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Sudoku.CasillaSudoku;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.TicTicTacH.Casilla;

public class InterfasDeJuegos {
    private ConfiguracionDeVisualBiblioteca configuracionesProyectoVisual = new ConfiguracionDeVisualBiblioteca();

    public void adivinaAnagramas(String palabraDesordenada) {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("| la palabra desordenada es: " + palabraDesordenada + " |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("| Ingrese la palabra correcta: |");
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void ticTacToe(Casilla[][] mapeoDeTablero, String turnoDeJugador) {

        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();

        System.out.println("    A  " + "   B   " + "  C  ");
        for (int i = 0; i < mapeoDeTablero.length; i++) {
            System.out.println(" |" + "-".repeat(5) + "|" + "-".repeat(5) + "|" + "-".repeat(5) + "|");
            System.out.println(i + "|  " + mapeoDeTablero[i][0].estadoDeCasilla() + "  |  "
                    + mapeoDeTablero[i][1].estadoDeCasilla() + "  |  " + mapeoDeTablero[i][2].estadoDeCasilla()
                    + "  |");
        }
        System.out.println(" |" + "-".repeat(5) + "|" + "-".repeat(5) + "|" + "-".repeat(5) + "|");
        System.out.println("Turno del jugador: " + turnoDeJugador);

    }

    public void sudoku(CasillaSudoku[][] mapeoDeSudoku) {

        int contador = 0;
        int contadorDeCeldasMayores = 3;
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        System.out.print("    A  " + "   B   " + "  C   " + "   D   " + "  E   " + "  F  " + "   G  " + "   H   "
                + "  I  ");
        for (int i = 0; i < mapeoDeSudoku.length; i++) {
            if (contadorDeCeldasMayores == 3) {
                System.out.println();
                System.out.println(" |" + "-".repeat(5) + "\033[38;5;244m|\033[0m" + "-".repeat(5)
                        + "\033[38;5;244m|\033[0m" + "-".repeat(5) + "|" + "-".repeat(5) + "\033[38;5;244m|\033[0m"
                        + "-".repeat(5) + "\033[38;5;244m|\033[0m" + "-".repeat(5) + "|" + "-".repeat(5)
                        + "\033[38;5;244m|\033[0m" + "-".repeat(5) + "\033[38;5;244m|\033[0m" + "-".repeat(5) + "|");
                contadorDeCeldasMayores = 0;
            } else {
                System.out.printf("%n%s%n",
                        " |" + "\033[38;5;244m-\033[0m".repeat(5) + "\033[38;5;244m|\033[0m"
                                + "\033[38;5;244m-\033[0m".repeat(5)
                                + "\033[38;5;244m|\033[0m" + "\033[38;5;244m-\033[0m".repeat(5) + "|"
                                + "\033[38;5;244m-\033[0m".repeat(5) + "\033[38;5;244m|\033[0m"
                                + "\033[38;5;244m-\033[0m".repeat(5) + "\033[38;5;244m|\033[0m"
                                + "\033[38;5;244m-\033[0m".repeat(5) + "|" + "\033[38;5;244m-\033[0m".repeat(5)
                                + "\033[38;5;244m|\033[0m" + "\033[38;5;244m-\033[0m".repeat(5)
                                + "\033[38;5;244m|\033[0m" + "\033[38;5;244m-\033[0m".repeat(5) + "|");

            }

            System.out.print(i);
            System.out.print("|");
            for (int j = 0; j < mapeoDeSudoku[i].length; j++) {
                contador++;
                System.out.print("  " + mapeoDeSudoku[i][j].getSimbolo() + "  ");

                if (contador == 3) {
                    System.out.print("|");
                    contador = 0;
                } else {
                    System.out.print("\033[38;5;244m|\033[0m");
                }
            }

            contadorDeCeldasMayores++;
        }
        System.out.println();
        System.out.println(" |" + "-".repeat(5) + "\033[38;5;244m|\033[0m" + "-".repeat(5)
                + "\033[38;5;244m|\033[0m" + "-".repeat(5) + "|" + "-".repeat(5) + "\033[38;5;244m|\033[0m"
                + "-".repeat(5) + "\033[38;5;244m|\033[0m" + "-".repeat(5) + "|" + "-".repeat(5)
                + "\033[38;5;244m|\033[0m" + "-".repeat(5) + "\033[38;5;244m|\033[0m" + "-".repeat(5) + "|");

        System.out.println("Ingrese la fila y columna de la celda que desea modificar (ejemplo: 1A):");
        configuracionesProyectoVisual.separadorDeLineas();

    }
}
