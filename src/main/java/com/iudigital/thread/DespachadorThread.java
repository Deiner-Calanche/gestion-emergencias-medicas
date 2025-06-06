package com.iudigital.thread;

import com.iudigital.model.Emergencia;
import com.iudigital.model.Recurso;
import com.iudigital.service.GestorEmergencias;
import com.iudigital.service.GestorRecursos;

import java.util.Optional;

public class DespachadorThread extends Thread {
    private final GestorEmergencias gestorEmergencias;
    private final GestorRecursos gestorRecursos;

    public DespachadorThread(GestorEmergencias gestorEmergencias, GestorRecursos gestorRecursos) {
        this.gestorEmergencias = gestorEmergencias;
        this.gestorRecursos = gestorRecursos;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Emergencia em = gestorEmergencias.obtenerSiguienteEmergencia();
            if (em == null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                continue;
            }

            Optional<Recurso> recursoOpt = gestorRecursos.asignarRecursoDisponible();
            if (recursoOpt.isPresent()) {
                Recurso recurso = recursoOpt.get();
                System.out.println("\u001B[36m[RECURSO ASIGNADO]\u001B[0m " + recurso + " -> " + em);
                new AmbulanciaThread(recurso).start();
            } else {
                System.out.println("\u001B[31m[NO HAY RECURSOS]\u001B[0m para " + em);
                gestorEmergencias.agregarEmergencia(em);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
