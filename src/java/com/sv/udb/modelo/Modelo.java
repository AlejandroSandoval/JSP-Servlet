/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sv.udb.modelo;

/**
 *
 * @author joseph
 */
public class Modelo {
    private int CodiMode;
    private String NombMode;
    private Double PrecioMode;
    private Marca codiMarc;

    public Modelo() {
    }

    public Modelo(int CodiMode, String NombMode, Double PrecioMode, Marca codiMarc) {
        this.CodiMode = CodiMode;
        this.NombMode = NombMode;
        this.PrecioMode = PrecioMode;
        this.codiMarc = codiMarc;
    }

    public int getCodiMode() {
        return CodiMode;
    }

    public void setCodiMode(int CodiMode) {
        this.CodiMode = CodiMode;
    }

    public String getNombMode() {
        return NombMode;
    }

    public void setNombMode(String NombMode) {
        this.NombMode = NombMode;
    }

    public Double getPrecioMode() {
        return PrecioMode;
    }

    public void setPrecioMode(Double PrecioMode) {
        this.PrecioMode = PrecioMode;
    }

    public Marca getCodiMarc() {
        return codiMarc;
    }

    public void setCodiMarc(Marca codiMarc) {
        this.codiMarc = codiMarc;
    }

    @Override
    public String toString() {
        return this.NombMode;
    }
}


