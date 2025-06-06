package com.iudigital.thread;

import com.iudigital.model.Emergencia;
import com.iudigital.service.GestorEmergencias;

public class OperadorThread extends Thread {
    private final GestorEmergencias gestor;

    public OperadorThread(GestorEmergencias gestor) {
        this.gestor = gestor;
    }

    @Override
    public void run() {
        int i = 1;
        while (!Thread.currentThread().isInterrupted()) {
            Emergencia em = new Emergencia("Accidente #" + i, (int)(Math.random() * 5 + 1), "Ubicación " + i);
            gestor.agregarEmergencia(em);
            i++;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}