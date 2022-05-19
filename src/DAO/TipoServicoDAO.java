/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class TipoServicoDAO extends Conexao {

    TipoServico tiposervico = new TipoServico();

    public List<TipoServico> tipservs() throws SQLException {
        List<TipoServico> tipservs = new ArrayList<TipoServico>();
// seleciona o nome dos tipos de serviço para o combobox do agendamento
        setSql("SELECT id, nomeTipoServ FROM tiposervico;");

        try {
            conectar();

            setPs((PreparedStatement) con.prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                TipoServico tiposerv = new TipoServico();
                tiposerv.setId(getRs().getInt("id"));
                tiposerv.setNomeTipoServico(getRs().getString("nomeTipoServ"));
                tipservs.add(tiposerv);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + e.getMessage());
            e.printStackTrace();
        } finally {
            desconectar();
            getPs().close();
            getRs().close();
        }
        return tipservs;

    }

}
