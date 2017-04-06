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
public class TipoUsuario {
    private int CodiTipoUsua;
    private String NombTipoUsua;

    public TipoUsuario() {
    }

    public TipoUsuario(int CodiTipoUsua, String NombTipoUsua) {
        this.CodiTipoUsua = CodiTipoUsua;
        this.NombTipoUsua = NombTipoUsua;
    }

    public int getCodiTipoUsua() {
        return CodiTipoUsua;
    }

    public void setCodiTipoUsua(int CodiTipoUsua) {
        this.CodiTipoUsua = CodiTipoUsua;
    }

    public String getNombTipoUsua() {
        return NombTipoUsua;
    }

    public void setNombTipoUsua(String NombTipoUsua) {
        this.NombTipoUsua = NombTipoUsua;
    }

    @Override
    public String toString() {
        return this.NombTipoUsua;
    }
    
}
