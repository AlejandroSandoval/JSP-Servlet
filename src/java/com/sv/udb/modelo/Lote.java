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
public class Lote {
    private int CodiLote;
    private Ensambladora CodiEnsa;
    private Encargado CodiEnca;

    public Lote() {
    }

    public Lote(int CodiLote, Ensambladora CodiEnsa, Encargado CodiEnca) {
        this.CodiLote = CodiLote;
        this.CodiEnsa = CodiEnsa;
        this.CodiEnca = CodiEnca;
    }

    public int getCodiLote() {
        return CodiLote;
    }

    public void setCodiLote(int CodiLote) {
        this.CodiLote = CodiLote;
    }

    public Ensambladora getCodiEnsa() {
        return CodiEnsa;
    }

    public void setCodiEnsa(Ensambladora CodiEnsa) {
        this.CodiEnsa = CodiEnsa;
    }

    public Encargado getCodiEnca() {
        return CodiEnca;
    }

    public void setCodiEnca(Encargado CodiEnca) {
        this.CodiEnca = CodiEnca;
    }
    
}
