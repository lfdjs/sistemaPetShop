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
public class Funcionario extends Pessoa {

    private int idFuncionario;
    private String tipoFunc;
    private int idTipoServico;

//    @Override
//    public void setCpf(Long cpf) {
//        super.setCpf(cpf); //To change body of generated methods, choose Tools | Templates.
//    }
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getTipoFunc() {
        return tipoFunc;
    }

    public void setTipoFunc(String tipoFunc) {
        this.tipoFunc = tipoFunc;
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
   
}
