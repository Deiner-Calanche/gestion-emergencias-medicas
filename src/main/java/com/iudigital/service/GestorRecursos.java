package com.iudigital.service;

import com.iudigital.model.Recurso;

import java.util.List;
import java.util.Optional;

public class GestorRecursos {
    private final List<Recurso> recursos;

    public GestorRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public synchronized Optional<Recurso> asignarRecursoDisponible() {
        return recursos.stream()
                .filter(Recurso::isDisponible)
                .findFirst()
                .filter(recurso -> recurso.asignar());
    }

    public void liberarRecurso(Recurso recurso) {
        recurso.liberar();
    }

    public void imprimirEstadoRecursos() {
        recursos.forEach(System.out::println);
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }
}
