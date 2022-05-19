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
public class Pet {

    private int idPet;
    private String nome;
    private String tipoAnimal;
    private String raca;
    private String sexo;

    /**
     * @return the idCliente
     */
    public int getIdPet() {
        return idPet;
    }

    /**
     * @param idPet the idCliente to set
     */
    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipoAnimal
     */
    public String getTipoAnimal() {
        return tipoAnimal;
    }

    /**
     * @param tipoAnimal the tipoAnimal to set
     */
    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    /**
     * @return the raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * @param raca the raca to set
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "" + getIdPet() + "," + getNome();
    }
}
