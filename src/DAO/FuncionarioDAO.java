/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Silva
 */
public class FuncionarioDAO extends Conexao implements Operacoes {

    Funcionario funcionario = new Funcionario();

    public void cadastrar(Funcionario func) throws SQLException {

        setSql("INSERT INTO funcionario "
                + "(nome, cpf, rg, "
                + "sexo, tipoFunc, idTipoServ)"
                + "VALUES(?,?,?,?,?,?);");

        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setString(1, func.getNome());
            getPs().setLong(2, func.getCpf());
            getPs().setInt(3, func.getRg());
            getPs().setString(4, String.valueOf(func.getSexo()));
            getPs().setString(5, func.getTipoFunc());
            getPs().setInt(6, func.getIdTipoServico());
            getPs().execute();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + ex);
        } finally {
            desconectar();
            getPs().close();
        }

    }

    public void alterar(Funcionario func) throws SQLException {
        setSql("UPDATE funcionario "
                + "SET nome = ?, cpf = ?, rg = ?, sexo = ?, "
                + "tipoFunc = ?, idTipoServ = ? WHERE idFuncionario = ?");

        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            //getPs().setInt(1, ((Agenda) obj).getIdAgenda());
            getPs().setString(1, func.getNome());
            getPs().setLong(2, func.getCpf());
            getPs().setInt(3, func.getRg());
            getPs().setString(4, String.valueOf(func.getSexo()));
            getPs().setString(5, func.getTipoFunc());
            getPs().setInt(6, func.getIdTipoServico());
            getPs().setInt(7, func.getIdFuncionario());
            getPs().execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + ex);
            ex.printStackTrace();
        } finally {
            desconectar();
            getPs().close();
        }
    }

    public void excluir(Funcionario veterinario) throws SQLException {
        setSql("DELETE FROM funcionario WHERE idFuncionario = ?");
        //sql = "DELETE FROM cargos WHERE idCargo = ?";
        try {

            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setInt(1, veterinario.getIdFuncionario());
            getPs().execute();

        } catch (Exception erro) {
            //Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro:\n" + erro.getMessage());
        } finally {
            desconectar();
            getPs().close();
        }

    }

    @Override
    public List<Object> exibir() throws SQLException {
        List<Object> veterinarios = new ArrayList<Object>();
        setSql("SELECT * FROM funcionario ORDER BY nome ASC");
        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                Funcionario func = new Funcionario();
                func.setIdFuncionario(getRs().getInt("idFuncionario"));
                func.setNome(getRs().getString("nome"));
                func.setCpf(getRs().getLong("cpf"));
                func.setRg(getRs().getInt("rg"));
                func.setSexo(getRs().getString("sexo"));
                func.setTipoFunc(getRs().getString("tipoFunc"));
                func.setIdTipoServico(getRs().getInt("idTipoServ"));
                veterinarios.add(func);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro \n" + e.getMessage());
        } finally {
            desconectar();
            getPs().close();
            getRs().close();
        }
        return veterinarios;
    }

   
}
