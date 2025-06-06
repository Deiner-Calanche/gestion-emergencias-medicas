package com.iudigital.service;

import com.iudigital.model.Emergencia;
import com.iudigital.model.Recurso;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class GestorEmergencias {
    private final PriorityBlockingQueue<Emergencia> colaEmergencias = new PriorityBlockingQueue<>();
    private final List<Recurso> recursos;

    public GestorEmergencias(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public void agregarEmergencia(Emergencia emergencia) {
        colaEmergencias.put(emergencia);
    }

    public Emergencia obtenerSiguienteEmergencia() {
        return colaEmergencias.poll();
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public PriorityBlockingQueue<Emergencia> getColaEmergencias() {
        return colaEmergencias;
    }
}
