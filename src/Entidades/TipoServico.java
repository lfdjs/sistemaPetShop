/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Silva
 */
public class TipoServico {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeTipoServico
     */
    public String getNomeTipoServico() {
        return nomeTipoServico;
    }

    /**
     * @param nomeTipoServico the nomeTipoServico to set
     */
    public void setNomeTipoServico(String nomeTipoServico) {
        this.nomeTipoServico = nomeTipoServico;
    }

    @Override
    public String toString() {
        return "" + id + "," + nomeTipoServico;
    }

    private int id;
    private String nomeTipoServico;
}
