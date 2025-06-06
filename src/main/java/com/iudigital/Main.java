package com.iudigital;

import com.iudigital.model.Recurso;
import com.iudigital.service.GestorEmergencias;
import com.iudigital.service.GestorRecursos;
import com.iudigital.thread.DespachadorThread;
import com.iudigital.thread.MonitorThread;
import com.iudigital.thread.OperadorThread;
import com.iudigital.view.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear recursos (ambulancias)
        List<Recurso> recursos = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            recursos.add(new Recurso(i));
        }

        // Crear gestores
        GestorEmergencias gestorEmergencias = new GestorEmergencias(recursos);
        GestorRecursos gestorRecursos = new GestorRecursos(recursos);

        // Crear hilos
        OperadorThread operadorThread = new OperadorThread(gestorEmergencias);
        DespachadorThread despachadorThread = new DespachadorThread(gestorEmergencias, gestorRecursos);
        MonitorThread monitorThread = new MonitorThread(gestorEmergencias, gestorRecursos);
        UI uiThread = new UI(gestorRecursos);

        // Iniciar hilos
        operadorThread.start();
        despachadorThread.start();
        monitorThread.start();
        uiThread.start();

        System.out.println("\n\u001B[32m=== Sistema de Gestión de Emergencias Médicas ===\u001B[0m");
        System.out.println("\u001B[33mEscribe 'exit' y presiona ENTER para finalizar el programa.\u001B[0m\n");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input.trim())) {
                System.out.println("\n\u001B[31mTerminando hilos...\u001B[0m");
                // Solicitar interrupción a todos los hilos
                operadorThread.interrupt();
                despachadorThread.interrupt();
                monitorThread.interrupt();
                uiThread.interrupt();
                break;
            } else {
                System.out.println("\u001B[33mComando no reconocido. Escribe 'exit' para salir.\u001B[0m");
            }
        }

        // Esperar a que los hilos finalicen correctamente
        try {
            operadorThread.join();
            despachadorThread.join();
            monitorThread.join();
            uiThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n\u001B[32m=== Sistema finalizado correctamente. ¡Hasta luego! ===\u001B[0m");
        scanner.close();
    }
}
