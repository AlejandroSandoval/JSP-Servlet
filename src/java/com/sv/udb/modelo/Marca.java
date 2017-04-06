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
public class Marca {
    private int CodiMarc;
    private String NombMarc;

    public Marca(int CodiMarc, String NombMarc) {
        this.CodiMarc = CodiMarc;
        this.NombMarc = NombMarc;
    }

    public Marca() {
    }

    public int getCodiMarc() {
        return CodiMarc;
    }

    public void setCodiMarc(int CodiMarc) {
        this.CodiMarc = CodiMarc;
    }

    public String getNombMarc() {
        return NombMarc;
    }

    public void setNombMarc(String NombMarc) {
        this.NombMarc = NombMarc;
    }

    @Override
    public String toString() {
        return this.NombMarc;
    }   
}
