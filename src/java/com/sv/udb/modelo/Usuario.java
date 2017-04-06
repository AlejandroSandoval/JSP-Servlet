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
public class Usuario {
    private int CodiUsua;
    private String NombUsua;
    private String ApelUsua;
    private String CorrUsua;
    private String UserUsua;
    private String PassUsua;
    private TipoUsuario CodiTipo;

    public Usuario() {
    }

    public Usuario(int CodiUsua, String NombUsua, String ApelUsua, String CorrUsua, String UserUsua, String PassUsua, TipoUsuario CodiTipo) {
        this.CodiUsua = CodiUsua;
        this.NombUsua = NombUsua;
        this.ApelUsua = ApelUsua;
        this.CorrUsua = CorrUsua;
        this.UserUsua = UserUsua;
        this.PassUsua = PassUsua;
        this.CodiTipo = CodiTipo;
    }

    public int getCodiUsua() {
        return CodiUsua;
    }

    public void setCodiUsua(int CodiUsua) {
        this.CodiUsua = CodiUsua;
    }

    public String getNombUsua() {
        return NombUsua;
    }

    public void setNombUsua(String NombUsua) {
        this.NombUsua = NombUsua;
    }

    public String getApelUsua() {
        return ApelUsua;
    }

    public void setApelUsua(String ApelUsua) {
        this.ApelUsua = ApelUsua;
    }

    public String getCorrUsua() {
        return CorrUsua;
    }

    public void setCorrUsua(String CorrUsua) {
        this.CorrUsua = CorrUsua;
    }

    public String getUserUsua() {
        return UserUsua;
    }

    public void setUserUsua(String UserUsua) {
        this.UserUsua = UserUsua;
    }

    public String getPassUsua() {
        return PassUsua;
    }

    public void setPassUsua(String PassUsua) {
        this.PassUsua = PassUsua;
    }

    public TipoUsuario getCodiTipo() {
        return CodiTipo;
    }

    public void setCodiTipo(TipoUsuario CodiTipo) {
        this.CodiTipo = CodiTipo;
    }

    @Override
    public String toString() {
        return this.NombUsua+" "+this.ApelUsua;
    }
   
}
