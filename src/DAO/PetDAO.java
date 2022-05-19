/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Pet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Silva
 */
public class PetDAO extends Conexao implements Operacoes {

    Pet pet = new Pet();

    public void cadastrar(Pet pet) throws SQLException {

        setSql("INSERT INTO pet"
                + "(nome, tipoAnimal, raca, "
                + "sexo)"
                + "VALUES(?,?,?,?);");

        try {
            //aqui ele faz o cadastro dos dados mediante o indice e a sequencia de interrogações citados no sql acima
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setString(1, pet.getNome());
            getPs().setString(2, pet.getTipoAnimal());
            getPs().setString(3, pet.getRaca());
            getPs().setString(4, String.valueOf(pet.getSexo()));
            getPs().execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + ex.getMessage());
        } finally {
            desconectar();
            getPs().close();// fecha o statement
        }
    }

    public void alterar(Pet pet) throws SQLException {
        setSql("UPDATE pet SET nome = ?, tipoAnimal = ?, raca = ?, sexo = ? where idPet = ?;");
        
        try {
            //aqui ele faz a alteração dos dados mediante o indice e a sequencia de interrogações citados no sql acima
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            //getPs().setInt(1, ((Agenda) obj).getIdAgenda());
            getPs().setString(1, pet.getNome());
            getPs().setString(2, pet.getTipoAnimal());
            getPs().setString(3, pet.getRaca());
            getPs().setString(4, String.valueOf(pet.getSexo()));
            getPs().setInt(5, pet.getIdPet());
            getPs().execute();
            System.out.println(pet.getNome()+" e "+pet.getTipoAnimal()+" e "+pet.getRaca()+" e "+pet.getSexo());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            desconectar();
            getPs().close();
        }

    }

    public void excluir(Pet pet) throws SQLException {
        setSql("DELETE FROM pet WHERE idPet = ?;");
        try {
            //aqui ele faz a exclusão dos dados mediante o indice e a interrogação citada no sql acima
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            getPs().setInt(1, pet.getIdPet());
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
        List<Object> pets = new ArrayList<Object>();
        setSql("SELECT * FROM pet;");
        try {
            // aqui ele faz o select dos dados, através de um ArayList
            conectar();
            setPs((PreparedStatement) con.prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                Pet pet = new Pet();
//                ag.setIdAgenda(getRs().getInt("idAgenda"));
//                ag.setTipoAtendimento(getRs().getString("tipoAtendimento"));
                pet.setIdPet(getRs().getInt("idPet"));
                pet.setNome(getRs().getString("nome"));
                pet.setTipoAnimal(getRs().getString("tipoAnimal"));
                pet.setRaca(getRs().getString("raca"));
                pet.setSexo(getRs().getString("sexo"));
                pets.add(pet);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + e.getMessage());
            e.printStackTrace();
        } finally {
            desconectar();
            getPs().close();
            getRs().close();
        }
        return pets;
    }


    public List<Pet> pets() throws SQLException {
        List<Pet> pets = new ArrayList<Pet>();
        // seleciona o nome dos pets para o combobox do agendamento

        setSql("SELECT * FROM pet;");

        try {
            conectar();

            setPs((PreparedStatement) con.prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                Pet pet = new Pet();
                pet.setIdPet(getRs().getInt("idPet"));
                pet.setNome(getRs().getString("nome"));
                pets.add(pet);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: \n" + e.getMessage());
        } finally {
            desconectar();
            getPs().close();
            getRs().close();
        }
        return pets;
    }

    

}
