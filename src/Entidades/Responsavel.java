/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author luizsilva
 */
public class Responsavel extends Pessoa {

    private int idResponsavel;
    private long telFixo;
    private long telCelular;
    private String email;

    /**
     * @return the idResponsavel
     */
    public int getIdResponsavel() {
        return idResponsavel;
    }

    /**
     * @param idResponsavel the idResponsavel to set
     */
    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    /**
     * @return the telFixo
     */
    public long getTelFixo() {
        return telFixo;
    }

    /**
     * @param telFixo the telFixo to set
     */
    public void setTelFixo(long telFixo) {
        this.telFixo = telFixo;
    }

    /**
     * @return the telCelular
     */
    public long getTelCelular() {
        return telCelular;
    }

    /**
     * @param telCelular the telCelular to set
     */
    public void setTelCelular(long telCelular) {
        this.telCelular = telCelular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
     @Override
    public String toString() {
        return "" + getIdResponsavel() + "," + getNome();
    }
}
