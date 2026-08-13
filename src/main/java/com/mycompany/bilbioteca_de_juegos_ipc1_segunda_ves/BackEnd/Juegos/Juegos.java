package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Juegos;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.BibliotecaReportesGlobales;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.MenusIniciales;

public abstract class Juegos {
    private MenusIniciales menu = new MenusIniciales();
    private Scanner scanner = new Scanner(System.in);

    public void inicioDeJuego(int dificultad, BibliotecaReportesGlobales reportesDatosEntrante) {

        String continuar;
        menu.menuDeJuegos(getNombre());
        continuar = scanner.nextLine();
        if (continuar.equalsIgnoreCase("1")) {
            jugar(dificultad, reportesDatosEntrante);
        } else {
            menu.regresandoAlMenuPrincipal();
        }
    }

    protected abstract String getNombre();

    protected abstract void jugar(int dificultad, BibliotecaReportesGlobales reportesDatosEntrante);

}
