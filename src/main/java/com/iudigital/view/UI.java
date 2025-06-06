package com.iudigital.view;

import com.iudigital.service.GestorRecursos;

public class UI extends Thread {
    private final GestorRecursos gestor;

    public UI(GestorRecursos gestor) {
        this.gestor = gestor;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("\n===== ESTADO DE RECURSOS =====");
            gestor.imprimirEstadoRecursos();
            System.out.println("==============================\n");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

