package com.iudigital.model;

public class Emergencia implements Comparable<Emergencia> {
    private final String tipo;
    private final int gravedad;
    private final String ubicacion;
    private final long tiempoReporte;

    public Emergencia(String tipo, int gravedad, String ubicacion) {
        this.tipo = tipo;
        this.gravedad = gravedad;
        this.ubicacion = ubicacion;
        this.tiempoReporte = System.currentTimeMillis();
    }

    public String getTipo() { return tipo; }
    public int getGravedad() { return gravedad; }
    public String getUbicacion() { return ubicacion; }
    public long getTiempoReporte() { return tiempoReporte; }

    @Override
    public int compareTo(Emergencia otra) {
        if (this.gravedad != otra.gravedad) {
            return Integer.compare(otra.gravedad, this.gravedad); // Invertido
        }
        return Long.compare(this.tiempoReporte, otra.tiempoReporte);
    }


    @Override
    public String toString() {
        return String.format("[\u001B[31mTipo\u001B[0m: %s, \u001B[33mGravedad\u001B[0m: %d, \u001B[34mUbicación\u001B[0m: %s]",
                tipo, gravedad, ubicacion);
    }
}

