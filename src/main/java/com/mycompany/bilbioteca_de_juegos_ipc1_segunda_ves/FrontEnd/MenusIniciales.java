package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

public class MenusIniciales {
    private ConfiguracionDeVisualBiblioteca configuracionesProyectoVisual = new ConfiguracionDeVisualBiblioteca();

    public void pantallaDeOpciones() {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-2s%s%4s%n", "| ", "Bienvenido a la biblioteca de juegos", " |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-3s%s%4s%n", "| ", "Seleccione el juego que desea jugar", " |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-12s%s%10s%n", "|", "1. Adivina anagramas", "|");
        System.out.printf("%-12s%s%16s%n", "|", "2. Tic Tac Toe", "|");
        System.out.printf("%-12s%s%21s%n", "|", "3. Sudoku", "|");
        System.out.printf("%-12s%s%21s%n", "|", "4. Salida", "|");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("Ingrese el número del juego que desea jugar:");
        configuracionesProyectoVisual.separadorDeLineas();

    }

    public void pantallaDeError() {
        configuracionesProyectoVisual.delayThread();
        System.out.print("\033[38;5;208m");
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-10s%s%9s%n%s%s%s%n", "| ", "Error: Opción inválida ", " |", "|",
                "Por favor, seleccione una opción válida ", "|");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.print("\033[0m");
    }

    public void pantallaDeSalida() {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-1s%s%1s%n%-15s%s%14s%n", "|", "Gracias por usar la biblioteca de juegos", "|", "|",
                "¡Hasta luego!", "|");
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void menuDeJuegos(int opcionDeJuego) {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        switch (opcionDeJuego) {
            case 1:
                System.out.printf("%-3s%s%2s%n", "| ", "Bienvenido al juego Adivina Anagramas", " |");
                break;
            case 2:
                System.out.printf("%-5s%s%6s%n", "| ", "Bienvenido al juego Tic Tac Toe", " |");
                break;

            default:
                System.out.printf("%-8s%s%8s%n", "| ", "Bienvenido al juego Sudoku", " |");
                break;
        }
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-10s%s%11s%n", "| ", "Seleccione una opción", " |");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-12s%s%22s%n", "|", "1. Jugar", "|");
        //System.out.printf("%-12s%s%7s%n", "|", "2. Ver reglas del juego", "|");
        System.out.printf("%-12s%s%12s%n", "|", "3. Salir del juego", "|");
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println("Ingrese el número de la opción que desea seleccionar:");
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void regresandoAlMenuPrincipal() {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.printf("%-3s%s%2s%n%-15s%s%14s%n", "|", "Regresando al menú principal", "|", "|",
                "¡Hasta luego!", "|");
        configuracionesProyectoVisual.separadorDeLineas();
    }
}
