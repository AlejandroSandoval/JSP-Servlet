/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author gersonfrancisco
 */
public class Escuela {
    private int CodiEscu;
    private String NombEscu;
    private String DireEscu;

    public Escuela() {
    }

    public Escuela(int CodiEscu, String NombEscu, String DireEscu) {
        this.CodiEscu = CodiEscu;
        this.NombEscu = NombEscu;
        this.DireEscu = DireEscu;
    }

    public int getCodiEscu() {
        return CodiEscu;
    }

    public void setCodiEscu(int CodiEscu) {
        this.CodiEscu = CodiEscu;
    }

    public String getNombEscu() {
        return NombEscu;
    }

    public void setNombEscu(String NombEscu) {
        this.NombEscu = NombEscu;
    }

    public String getDireEscu() {
        return DireEscu;
    }

    public void setDireEscu(String DireEscu) {
        this.DireEscu = DireEscu;
    }

    @Override
    public String toString() {
        return this.NombEscu;
    }
    
    
}
