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
public class Encargado {
    private int CodiEnca;
    private String DuiEnca;
    private int TeleEnca;
    private Escuela CodiEscu;
    private Usuario codiUsua;

    public Encargado() {
    }

    public Encargado(int CodiEnca, String DuiEnca, int TeleEnca, Escuela CodiEscu, Usuario codiUsua) {
        this.CodiEnca = CodiEnca;
        this.DuiEnca = DuiEnca;
        this.TeleEnca = TeleEnca;
        this.CodiEscu = CodiEscu;
        this.codiUsua = codiUsua;
    }

    public int getCodiEnca() {
        return CodiEnca;
    }

    public void setCodiEnca(int CodiEnca) {
        this.CodiEnca = CodiEnca;
    }

    public String getDuiEnca() {
        return DuiEnca;
    }

    public void setDuiEnca(String DuiEnca) {
        this.DuiEnca = DuiEnca;
    }

    public int getTeleEnca() {
        return TeleEnca;
    }

    public void setTeleEnca(int TeleEnca) {
        this.TeleEnca = TeleEnca;
    }

    public Escuela getCodiEscu() {
        return CodiEscu;
    }

    public void setCodiEscu(Escuela CodiEscu) {
        this.CodiEscu = CodiEscu;
    }

    public Usuario getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Usuario codiUsua) {
        this.codiUsua = codiUsua;
    }
    
}
