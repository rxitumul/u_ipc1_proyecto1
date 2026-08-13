package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Juegos.AdivinaAnagramas;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Juegos.Juegos;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Juegos.SudokuJuego;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd.Juegos.TicTicTac;
import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.MenusIniciales;

public class MenuLoguica {

    private MenusIniciales menu = new MenusIniciales();
    private Scanner scanner = new Scanner(System.in);
    private int opcionDeJuego;
    private BibliotecaReportesGlobales reportesDatos = new BibliotecaReportesGlobales();

    public void menuDeOpciones() {
        boolean opcionValida = true;
        while (opcionValida) {
            menu.pantallaDeOpciones();
            try {
                opcionDeJuego = Integer.parseInt(scanner.nextLine());
                if (opcionDeJuego >= 1 && opcionDeJuego <= 3) {
                    llamadaDeMenuDeJuegos(opcionDeJuego);
                } else if (opcionDeJuego == 4) {
                    ReportesGlobales reportes = new ReportesGlobales();
                    reportes.reportes(reportesDatos);
                } else if (opcionDeJuego == 5) {
                    menu.pantallaDeSalida();
                    opcionValida = false;
                } else {
                    menu.pantallaDeError();
                }
            } catch (Exception e) {
                menu.pantallaDeError();
            }
        }
    }

    public void llamadaDeMenuDeJuegos(int opcionDeJuego) {
        int dificultad = 0;
        if (opcionDeJuego == 3) {
            while (true) {
                try {
                    menu.selectorDeDificultad();
                    dificultad = Integer.parseInt(scanner.nextLine());
                    switch (dificultad) {
                        case 1:
                            dificultad = 30;
                            break;
                        case 2:
                            dificultad = 46;
                            break;
                        default:
                            dificultad = 64;
                            break;
                    }

                    break;
                } catch (NumberFormatException e) {
                    menu.pantallaDeError();
                }
            }
        }
        Juegos juegoSeleccionado;
        switch (opcionDeJuego) {
            case 1:
                juegoSeleccionado = new AdivinaAnagramas();
                break;
            case 2:
                juegoSeleccionado = new TicTicTac();
                break;
            case 3:
                juegoSeleccionado = new SudokuJuego();
                break;
            default:
                juegoSeleccionado = null;
                break;
        }

        if (juegoSeleccionado != null) {
            juegoSeleccionado.inicioDeJuego(dificultad, reportesDatos);
        }
    }
}
