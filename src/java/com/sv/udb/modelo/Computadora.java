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
public class Computadora {
    private int CodiComp;
    private String FechFabr;
    private String NumeSeri;
    private int EstaCompu;
    private Modelo CodiMode;
    private Lote CodiLote;

    public Computadora() {
    }

    public Computadora(int CodiComp, String FechFabr, String NumeSeri, int EstaCompu, Modelo CodiMode, Lote CodiLote) {
        this.CodiComp = CodiComp;
        this.FechFabr = FechFabr;
        this.NumeSeri = NumeSeri;
        this.EstaCompu = EstaCompu;
        this.CodiMode = CodiMode;
        this.CodiLote = CodiLote;
    }

    public int getCodiComp() {
        return CodiComp;
    }

    public void setCodiComp(int CodiComp) {
        this.CodiComp = CodiComp;
    }

    public String getFechFabr() {
        return FechFabr;
    }

    public void setFechFabr(String FechFabr) {
        this.FechFabr = FechFabr;
    }

    public String getNumeSeri() {
        return NumeSeri;
    }

    public void setNumeSeri(String NumeSeri) {
        this.NumeSeri = NumeSeri;
    }

    public int getEstaCompu() {
        return EstaCompu;
    }

    public void setEstaCompu(int EstaCompu) {
        this.EstaCompu = EstaCompu;
    }

    public Modelo getCodiMode() {
        return CodiMode;
    }

    public void setCodiMode(Modelo CodiMode) {
        this.CodiMode = CodiMode;
    }

    public Lote getCodiLote() {
        return CodiLote;
    }

    public void setCodiLote(Lote CodiLote) {
        this.CodiLote = CodiLote;
    }
    
}
