package com.example.lab2prueba.model;

public class Seguro {
    private String empresa_asegur;
    private double cobertura_max;
    private double tarifa;

    public String getEmpresa_asegur() {
        return empresa_asegur;
    }

    public void setEmpresa_asegur(String empresa_asegur) {
        this.empresa_asegur = empresa_asegur;
    }

    public double getCobertura_max() {
        return cobertura_max;
    }

    public void setCobertura_max(double cobertura_max) {
        this.cobertura_max = cobertura_max;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
}
