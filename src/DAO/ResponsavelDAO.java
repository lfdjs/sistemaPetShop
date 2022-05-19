/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Responsavel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Silva
 */
public class ResponsavelDAO extends Conexao implements Operacoes {

    Responsavel responsavel = new Responsavel();

    
    public void cadastrar(Responsavel responsavel) throws SQLException {
        setSql("INSERT INTO responsavel "
                + "(nome, cpf, rg, "
                + "sexo, telFixo, telCelular, email)"
                + "VALUES(?,?,?,?,?,?,?);");

        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setString(1, responsavel.getNome());
            getPs().setLong(2, responsavel.getCpf());
            getPs().setInt(3, responsavel.getRg());
            getPs().setString(4, responsavel.getSexo());
            getPs().setLong(5, responsavel.getTelFixo());
            getPs().setLong(6, responsavel.getTelCelular());
            getPs().setString(7, responsavel.getEmail());
            getPs().execute();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + ex.getMessage());
        } finally {
            desconectar();
            getPs().close();
        }
    }

    
    public void alterar(Responsavel responsavel) throws SQLException {
        setSql(""
                + "UPDATE responsavel "
                + "SET nome = ?, cpf = ?, rg = ?, "
                + "sexo = ?, telFixo = ?, telCelular = ?, email = ?"
                + "WHERE idResponsavel = ?;"
               );

        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setString(1, responsavel.getNome());
            getPs().setLong(2, responsavel.getCpf());
            getPs().setInt(3, responsavel.getRg());
            getPs().setString(4, responsavel.getSexo());
            getPs().setLong(5, responsavel.getTelFixo());
            getPs().setLong(6, responsavel.getTelCelular());
            getPs().setString(7, responsavel.getEmail());
            getPs().setInt(8, responsavel.getIdResponsavel());
            getPs().execute();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + ex.getMessage());
        } finally {
            desconectar();
            getPs().close();
        }
    }

    
    public void excluir(Responsavel responsavel) throws SQLException {
        setSql("DELETE FROM responsavel WHERE idResponsavel = ?;");
        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setInt(1, responsavel.getIdResponsavel());
            getPs().execute();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + e.getMessage());
        } finally {
            desconectar();
            getPs().close();
        }
    }

    @Override
    public List<Object> exibir() throws SQLException {
        List<Object> responsaveis = new ArrayList<Object>();
        setSql("SELECT * FROM responsavel;");
        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                Responsavel resp = new Responsavel();
                resp.setIdResponsavel(getRs().getInt("idResponsavel"));
                resp.setNome(getRs().getString("nome"));
                resp.setCpf(getRs().getLong("cpf"));
                resp.setRg(getRs().getInt("rg"));
                resp.setSexo(getRs().getString("sexo"));
                resp.setTelFixo(getRs().getLong("telFixo"));
                resp.setTelCelular(getRs().getLong("telCelular"));
                resp.setEmail(getRs().getString("email"));
                responsaveis.add(resp);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + e.getMessage());
        } finally {
            desconectar();
            getPs().close();
            getRs().close();
        }
        return responsaveis;
    }

//    @Override
//    public List<Object> pesquisaFiltro(Object obj) {
//        throw new UnsupportedOperationException("Em manutenção");
//    }

    public List<Responsavel> responsaveis() throws SQLException {
        List<Responsavel> responsaveis = new ArrayList<Responsavel>();
// seleciona o nome dos responsaveis para o combobox do agendamento
        setSql("SELECT idResponsavel, nome FROM responsavel;");

        try {
            conectar();

            setPs((PreparedStatement) con.prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                Responsavel resp = new Responsavel();
                resp.setIdResponsavel(getRs().getInt("idResponsavel"));
                resp.setNome(getRs().getString("nome"));
                responsaveis.add(resp);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro na consulta de responsáveis: \n" + e.getMessage());
        } finally {
            desconectar();
            getPs().close();
            getRs().close();
        }
        return responsaveis;

    }

}
