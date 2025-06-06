package com.iudigital.thread;

import com.iudigital.model.Emergencia;
import com.iudigital.model.Recurso;
import com.iudigital.service.GestorEmergencias;
import com.iudigital.service.GestorRecursos;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class MonitorThread extends Thread {

    private final GestorEmergencias gestorEmergencias;
    private final GestorRecursos gestorRecursos;

    public MonitorThread(GestorEmergencias gestorEmergencias, GestorRecursos gestorRecursos) {
        this.gestorEmergencias = gestorEmergencias;
        this.gestorRecursos = gestorRecursos;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("\n===== ESTADO DEL SISTEMA =====");

                PriorityBlockingQueue<Emergencia> cola = gestorEmergencias.getColaEmergencias();
                if (cola.isEmpty()) {
                    System.out.println("🆗 No hay emergencias pendientes.");
                } else {
                    System.out.println("🚨 Emergencias en espera:");
                    cola.forEach(emergencia -> {
                        System.out.printf("  - %s (Gravedad: %d, Ubicación: %s)\n",
                                emergencia.getTipo(), emergencia.getGravedad(), emergencia.getUbicacion());
                    });
                }

                List<Recurso> recursos = gestorRecursos.getRecursos();
                System.out.println("🚑 Recursos:");
                recursos.forEach(recurso -> {
                    System.out.printf("  - %s: %s\n",
                            recurso.getNombre(),
                            recurso.isDisponible() ? "Disponible ✅" : "Ocupado ❌");
                });

                System.out.println("==============================\n");

                Thread.sleep(8000);
            } catch (InterruptedException e) {
                System.err.println("[MONITOR] Interrumpido: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}