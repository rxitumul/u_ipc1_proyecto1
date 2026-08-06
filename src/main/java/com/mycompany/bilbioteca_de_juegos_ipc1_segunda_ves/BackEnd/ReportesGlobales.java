package com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.BackEnd;

import java.util.Scanner;

import com.mycompany.bilbioteca_de_juegos_ipc1_segunda_ves.FrontEnd.ReportesInterfaces;

public class ReportesGlobales {

    private BibliotecaReportesGlobales reportesDatos;
    private ReportesInterfaces interfaces = new ReportesInterfaces();
    private Scanner scanner = new Scanner(System.in);

    public void reportes(BibliotecaReportesGlobales reportesDatosEntrante) {
        reportesDatos = reportesDatosEntrante;
        interfaces.reporteAnagramas(reportesDatos.getPartidasJugadasA(), reportesDatos.getPalabrasAdivinadasA(),
                reportesDatos.getIntentosFallidosA(), reportesDatos.getPorcentajeVictoriasA());
        interfaces.reporteSudoku(reportesDatos.getPartidasGanadasS(), reportesDatos.getPartidasAbandonadasS(),
                reportesDatos.getPromedioJugadasInvalidasS(), reportesDatos.getRecordMenosJugadasS());
        interfaces.reporteTicTacToe(reportesDatos.getVictoriasJugadorT(), reportesDatos.getVictoriasMaquinaT(),
                reportesDatos.getEmpatesT(), reportesDatos.getRachaVictoriasT(), reportesDatos.getRachaDerrotasT(),
                reportesDatos.getPromedioJugadasT());
        scanner.nextLine();
    }
}