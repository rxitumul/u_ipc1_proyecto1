package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

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

    public void ticTacToe(int[][] mapeoDeTablero, String turnoDeJugador) {
        String[][] simboloDeJugador = new String[3][3];

        for (int i = 0; i < mapeoDeTablero.length; i++) {
            for (int j = 0; j < mapeoDeTablero[i].length; j++) {
                if (mapeoDeTablero[i][j] == 1) {
                    simboloDeJugador[i][j] = "\033[31mX\033[0m";
                } else if (mapeoDeTablero[i][j] == 2) {
                    simboloDeJugador[i][j] = "\033[34mO\033[0m";
                } else {
                    simboloDeJugador[i][j] = " ";
                }
            }
        }
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();

        System.out.println("    A  " + "   B   " + "  C  ");
        for (int i = 0; i < mapeoDeTablero.length; i++) {
            System.out.println(" |" + "-".repeat(5) + "|" + "-".repeat(5) + "|" + "-".repeat(5) + "|");
            System.out.println(i + "|  " + simboloDeJugador[i][0] + "  |  " + simboloDeJugador[i][1] + "  |  "
                    + simboloDeJugador[i][2] + "  |");
                }
                System.out.println(" |" + "-".repeat(5) + "|" + "-".repeat(5) + "|" + "-".repeat(5) + "|");

        System.out.println("Turno del jugador: " + turnoDeJugador);

    }

    public void sudoku(int[][] mapeoDeSudoku) {

        int contador = 0;
        int contadorDeCeldasMayores = 3;
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        System.out.println("    A  " + "   B   " + " C  " + "  D  " + "   E   " + "  F  " + " G  " + "   H   "
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
                if (mapeoDeSudoku[i][j] == 0) {
                    System.out.print("     ");
                } else {
                    System.out.print("  " + mapeoDeSudoku[i][j] + "  ");
                }
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

                System.out.println("Ingrese la fila y columna de la celda que desea modificar (ejemplo: A1):");
                configuracionesProyectoVisual.separadorDeLineas();

    }
}
