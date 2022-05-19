/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Agenda;
import Entidades.Funcionario;
import Entidades.Pet;
import Entidades.Responsavel;
import Entidades.TipoServico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Silva
 */
public class AgendaDAO extends Conexao implements Operacoes {

    Agenda agenda = new Agenda();

    public void cadastrar(Agenda agenda) throws SQLException {
        setSql("INSERT INTO agenda "
                + "(dataAtendimento, horaAtendimento, "
                + "idPet, idTipoServico, idResponsavel)"
                + "VALUES(?,?,?,?,?);");

        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            //getPs().setInt(1, ((Agenda) obj).getIdAgenda());

            getPs().setString(1, agenda.getDataAtendimento());
            getPs().setString(2, agenda.getHoraAtendimento());
            getPs().setInt(3, agenda.getIdPet());
            getPs().setInt(4, agenda.getIdTipoServico());
            getPs().setInt(5, agenda.getIdResponsavel());
            getPs().execute();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + ex.getMessage());
        } finally {
            desconectar();
            getPs().close();
        }

    }

    public void alterar(Agenda agenda) throws SQLException {
        setSql("UPDATE agenda "
                + "SET dataAtendimento = ?, horaAtendimento = ?, "
                + "idPet = ?, idTipoServico = ?, idResponsavel = ? "
                + "WHERE idAgenda = ?;");
        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setString(1, agenda.getDataAtendimento());
            getPs().setString(2, agenda.getHoraAtendimento());
            getPs().setInt(3, agenda.getIdPet());
            getPs().setInt(4, agenda.getIdTipoServico());
            getPs().setInt(5, agenda.getIdResponsavel());
            getPs().setInt(6, agenda.getIdAgenda());
            getPs().execute();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + e.getMessage());
        } finally {
            desconectar();
            getPs().close();
        }

    }

    public void excluir(Agenda agenda) throws SQLException {
        setSql("DELETE FROM agenda WHERE idAgenda = ?;");
        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setInt(1, agenda.getIdAgenda());
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
        List<Object> agendas = new ArrayList<>();
        setSql("SELECT * FROM agenda;");
        try {
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                Agenda ag = new Agenda();
                ag.setIdAgenda(getRs().getInt("idAgenda"));
                ag.setDataAtendimento(getRs().getString("dataAtendimento"));
                ag.setHoraAtendimento(getRs().getString("horaAtendimento"));
                ag.setIdPet(getRs().getInt("idPet"));
                ag.setIdTipoServico(getRs().getInt("idTipoServico"));
                ag.setIdResponsavel(getRs().getInt("idResponsavel"));
                agendas.add(ag);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + e.getMessage());
        } finally {
            desconectar();
            getPs().close();
            getRs().close();
        }
        return agendas;
    }

//    @Override
//    public List<Object> pesquisaFiltro(Object obj) throws SQLException {
//        List<Object> dados = new ArrayList<Object>();
//        setSql("SELECT * FROM agenda WHERE dataAtendimento LIKE ?");
//        //sql = " SELECT * FROM cargos WHERE nomeCargo LIKE ?";
//        try {
//            conectar();
//            setPs((PreparedStatement) con.prepareStatement(getSql()));
//            getPs().setString(1, "%" + agenda.getDataAtendimento() + "%");
//            setRs(getPs().executeQuery());
//
//            while (getRs().next()) {
//                Agenda ag = new Agenda();
//                //A ser implementado posteriormente quando acertar o select join
//                dados.add(ag);
//            }
//        } catch (ClassNotFoundException erro) {
//            //Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Ocorreu um erro:\n" + erro);
//        } finally {
//            desconectar();
//            getPs().close();
//            getRs().close();
//        }
//        return dados;
//    }

}
