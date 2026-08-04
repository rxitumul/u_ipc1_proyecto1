package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

public class MenusIniciales {
    private ConfiguracionDeVisualBiblioteca configuracionesProyectoVisual = new ConfiguracionDeVisualBiblioteca();

    public void pantallaDeOpciones() {

        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-2s%s%4s%n", "| ", "Bienvenido a la biblioteca de juegos", " |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-3s%s%4s%n", "| ", "Seleccione el juego que desea jugar", " |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-12s%s%10s%n", "|", "1. Adivina anagramas", "|");
        System.out.printf("%-12s%s%16s%n", "|", "2. Tic Tac Toe", "|");
        System.out.printf("%-12s%s%21s%n", "|", "3. Sudoku", "|");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("Ingrese el número del juego que desea jugar:");
        configuracionesProyectoVisual.separadorDeLineas();

    }

    public void pantallaDeError() {
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-10s%s%9s%n%s%s%s%n", "| ", "Error: Opción inválida ", " |", "|",
                "Por favor, seleccione una opción válida ", "|");
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void pantallaDeSalida() {
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-1s%s%1s%n%-15s%s%14s%n", "|", "Gracias por usar la biblioteca de juegos", "|", "|",
                "¡Hasta luego!", "|");
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void menuDeJuegoAdivinaAnagramas(int opcionDeJuego) {
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-2s%s%4s%n", "| ", "Bienvenido al juego Adivina Anagramas", " |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-3s%s%4s%n", "| ", "Seleccione una opción", " |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-12s%s%10s%n", "|", "1. Jugar", "|");
        System.out.printf("%-12s%s%16s%n", "|", "2. Ver reglas del juego", "|");
        System.out.printf("%-12s%s%21s%n", "|", "3. Salir del juego", "|");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("Ingrese el número de la opción que desea seleccionar:");
        configuracionesProyectoVisual.separadorDeLineas();
    }

}
