package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd;

public class MenusIniciales {
    private ConfiguracionDeVisualBiblioteca configuracionesProyectoVisual = new ConfiguracionDeVisualBiblioteca();

    public void pantallaDeOpciones() {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Bienvenido a la biblioteca de juegos"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Seleccione el juego que desea jugar"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("1. Adivina anagramas"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("2. Tic Tac Toe"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("3. Sudoku"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("4. Reportes"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("5. Salida"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Ingrese el número del juego"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("que desea jugar:"));
        configuracionesProyectoVisual.separadorDeLineas();

    }

    public void pantallaDeError() {
        configuracionesProyectoVisual.delayThread();
        System.out.print("\033[38;5;208m");
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Error: Opción inválida "));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Por favor, seleccione una opción válida "));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.print("\033[0m");
    }

    public void pantallaDeSalida() {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Gracias por usar la biblioteca de juegos"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("¡Hasta luego!"));
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void menuDeJuegos(String opcionDeJuego) {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado(opcionDeJuego));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Seleccione una opción"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("1. Jugar"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("precione enter o escriba cualquier otra "));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("tecla para regresar al menu principal"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Ingrese uno para jugar"));
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void regresandoAlMenuPrincipal() {
        configuracionesProyectoVisual.delayThread();
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Regresando al menú principal"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("¡Hasta luego!"));
        configuracionesProyectoVisual.separadorDeLineas();
    }

    public void selectorDeDificultad() {
        configuracionesProyectoVisual.limpiarPantalla();
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Eliga una dificultad "));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Seleccione una opción"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("1. Facil"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("2. Medio"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("3. Dificil"));
        configuracionesProyectoVisual.separadorDeLineas();
        System.out.println(configuracionesProyectoVisual.formatearCentrado("Ingrese el número de la opción que desea"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("seleccionar. De lo contrario,la"));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("dificultad se configurará en "));
        System.out.println(configuracionesProyectoVisual.formatearCentrado("difícil por defecto."));
        configuracionesProyectoVisual.separadorDeLineas();
    }
}
