package com.iudigital.thread;

import com.iudigital.model.Recurso;

public class AmbulanciaThread extends Thread {
    private final Recurso recurso;

    public AmbulanciaThread(Recurso recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {
        try {
            System.out.println("[AMBULANCIA] 🚑 " + recurso.getNombre() + " está atendiendo una emergencia...");
            Thread.sleep((long) (5000 + Math.random() * 5000));
        } catch (InterruptedException e) {
            System.err.println("[ERROR] Ambulancia interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            recurso.liberar();
            System.out.println("[AMBULANCIA] ✅ " + recurso.getNombre() + " está disponible nuevamente.");
        }
    }

}
