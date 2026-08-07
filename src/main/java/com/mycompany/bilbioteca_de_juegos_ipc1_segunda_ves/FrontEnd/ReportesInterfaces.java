package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

public class ReportesInterfaces {

    private ConfiguracionDeVisualBiblioteca configuracionesProyectoVisual = new ConfiguracionDeVisualBiblioteca();

    public void reporteAnagramas(int partidasJugadas, int palabrasAdivinadas, int intentosFallidos,
            double porcentajeVictorias) {
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("|           REPORTE: ANAGRAMAS           |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("| Partidas jugadas: %-20d |\n", partidasJugadas);
        System.out.printf("| Palabras adiv. (Total): %-14d |\n", palabrasAdivinadas);
        System.out.printf("| Intentos fallidos: %-19d |\n", intentosFallidos);

        String val = String.format("%.1f%%", porcentajeVictorias);
        System.out.printf("| Porcentaje victorias: %-16s |\n", val);
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void reporteTicTacToe(int victoriasJugador, int victoriasMaquina, int empates, int rachaVictorias,
            int rachaDerrotas, double promedioJugadas) {
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("|          REPORTE: TIC TAC TOE          |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("| Victorias del Jugador: %-15d |\n", victoriasJugador);
        System.out.printf("| Victorias de la Maquina: %-13d |\n", victoriasMaquina);
        System.out.printf("| Empates: %-29d |\n", empates);
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("| Racha actual victorias: %-14d |\n", rachaVictorias);
        System.out.printf("| Racha actual derrotas: %-15d |\n", rachaDerrotas);

        String val = String.format("%.1f", promedioJugadas);
        System.out.printf("| Promedio jugadas/partida: %-12s |\n", val);
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("Presione enter para salir ");
    }

    public void reporteSudoku(int partidasGanadas, int partidasAbandonadas, double promedioJugadasInvalidas,
            int recordMenosJugadas) {
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("|            REPORTE: SUDOKU             |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("| Partidas ganadas: %-20d |\n", partidasGanadas);
        System.out.printf("| Partidas abandonadas: %-16d |\n", partidasAbandonadas);

        String val = String.format("%.1f", promedioJugadasInvalidas);
        System.out.printf("| Promedio jugadas invalidas: %-10s |\n", val);

        // Si el récord está inicializado en un valor altísimo (ej. Integer.MAX_VALUE) y
        // no han ganado, se muestra N/A
        String recordStr = (recordMenosJugadas == Integer.MAX_VALUE) ? "N/A" : String.valueOf(recordMenosJugadas);
        System.out.printf("| Record menor # jugadas: %-14s |\n", recordStr);
        configuracionesProyectoVisual.separadorDeLineas();
    }
}
