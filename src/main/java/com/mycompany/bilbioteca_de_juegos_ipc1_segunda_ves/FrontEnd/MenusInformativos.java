package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

public class MenusInformativos {
    private ConfiguracionDeVisualBiblioteca configuracionesProyectoVisual = new ConfiguracionDeVisualBiblioteca();

    public void condicionDePartidaFinalizada(String partida) {
        System.out.println("\n¡Es un" + partida);
        System.out.println("Presione Enter para continuar...");
    }

    public void mensajeDeError() {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        System.out.print("\033[38;5;208m");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Movimiento invalido, intente de nuevo"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.print("\033[0m");
    }

    public void mensajeDeVictoriaSudoku() {
        System.out.println("\n|----------------------------------------|");
        System.out.println(configuracionesProyectoVisual.formatearCentrado("¡FELICIDADES! GANASTE"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Completaste el Sudoku correctamente"));
        System.out.println("|----------------------------------------|\n");
        System.out.println("Presione Enter para continuar...");
    }

    public void mensajeDeDerrotaAnagramas() {
        System.out.println("\n|----------------------------------------|");
        System.out.println(configuracionesProyectoVisual.formatearCentrado("¡PERDISTE!"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Te has quedado sin intentos."));
        System.out.println("|----------------------------------------|\n");
        System.out.println("Presione Enter para continuar...");
    }

    public void mensajeDeVictoriaAnagramas() {
        System.out.println("\n|----------------------------------------|");
        System.out.println(configuracionesProyectoVisual.formatearCentrado("¡GANASTE!"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("¡Encontraste todos los anagramas!"));
        System.out.println("|----------------------------------------|\n");
        System.out.println("Presione Enter para continuar...");
    }

    public void mensajeDeErrorRepetidoAnagramas() {
        System.out.println("\n|----------------------------------------|");
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Esa palabra ya la habías encontrado."));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Intenta con otra distinta."));
        System.out.println("|----------------------------------------|\n");
    }

    public void mensajeDeErrorAnagramas() {
        System.out.println("\n|----------------------------------------|");
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Palabra inválida o no es un anagrama."));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("¡Intento fallido!"));
        System.out.println("|----------------------------------------|\n");
    }
}
