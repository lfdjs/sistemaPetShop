/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Silva
 */
public interface Operacoes {
/* a interface operações somente tem o método de exibir visto que não 
conseguimos executar os demais mpétodos crud, 
visto que recebem como argumentos as suas respectivas classes*/
    List<Object> exibir() throws SQLException;

}
