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
public class Ensambladora {
    private int CodiEnsa;
    private String NombEnsa;
    private String DireEnsa;

    public Ensambladora(int CodiEnsa, String NombEnsa, String DireEnsa) {
        this.CodiEnsa = CodiEnsa;
        this.NombEnsa = NombEnsa;
        this.DireEnsa = DireEnsa;
    }

    public int getCodiEnsa() {
        return CodiEnsa;
    }

    public void setCodiEnsa(int CodiEnsa) {
        this.CodiEnsa = CodiEnsa;
    }

    public String getNombEnsa() {
        return NombEnsa;
    }

    public void setNombEnsa(String NombEnsa) {
        this.NombEnsa = NombEnsa;
    }

    public String getDireEnsa() {
        return DireEnsa;
    }

    public void setDireEnsa(String DireEnsa) {
        this.DireEnsa = DireEnsa;
    }

    public Ensambladora() {
    }

    @Override
    public String toString() {
        return this.NombEnsa;
    }
    
    
}


