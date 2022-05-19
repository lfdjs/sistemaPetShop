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
public class Agenda {

    private int idAgenda;
    private String dataAtendimento;
    private String horaAtendimento;
    private int idPet;
    private int idTipoServico;
    private int idResponsavel;

    /**
     * @return the idAgenda
     */
    public int getIdAgenda() {
        return idAgenda;
    }

    /**
     * @param idAgenda the idAgenda to set
     */
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    
    /**
     * @return the dataAtendimento
     */
    public String getDataAtendimento() {
        return dataAtendimento;
    }

    /**
     * @param dataAtendimento the dataAtendimento to set
     */
    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    /**
     * @return the horaAtendimento
     */
    public String getHoraAtendimento() {
        return horaAtendimento;
    }

    /**
     * @param horaAtendimento the horaAtendimento to set
     */
    public void setHoraAtendimento(String horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    /**
     * @return the idPet
     */
    public int getIdPet() {
        return idPet;
    }

    /**
     * @param idPet the idPet to set
     */
    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    /**
     * @return the idTipoServico
     */
    public int getIdTipoServico() {
        return idTipoServico;
    }

    /**
     * @param idTipoServico the idTipoServico to set
     */
    public void setIdTipoServico(int idTipoServico) {
        this.idTipoServico = idTipoServico;
    }

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

}
