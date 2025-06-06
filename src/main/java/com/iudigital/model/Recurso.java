package com.iudigital.model;

public class Recurso {
    private final int id;
    private boolean disponible = true;

    public Recurso(int id) {
        this.id = id;
    }

    public synchronized boolean asignar() {
        if (disponible) {
            disponible = false;
            return true;
        }
        return false;
    }

    public synchronized void liberar() {
        disponible = true;
    }

    public synchronized boolean isDisponible() {
        return disponible;
    }

    public synchronized void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombre() {
        return "Ambulancia #" + id;
    }

    @Override
    public String toString() {
        return String.format("%s [%s\u001B[0m]",
                getNombre(),
                disponible ? "\u001B[32mDisponible" : "\u001B[31mOcupado");
    }
}


