/*Classes necessárias para uso de Banco de dados /*/
package DAO;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    // Declaração de atributos
    public Connection con;
    private Statement stm;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    //Declaração de atributos da conexão com o banco de dados
//    private final String usuario = "root";
//    private final String senha = "";
//    private final String url = "jdbc:mysql://localhost/petshop";
//    private final String driver = "com.mysql.cj.jdbc.Driver";

    private final String usuario = "Usuario do Banco";
    private final String senha = "senha do banco";
    private final String url = "jdbc:mysql://db4free.net:3306/petshop";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    //getters e setters do sql, do preparedstatement e do result set, que são usados nas clases filhas dao
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public boolean conectar() throws ClassNotFoundException {
// método de conexão ao banco de dados
        try {
            Class.forName(driver);// atribui o driver
            con = (Connection) DriverManager.getConnection(url, usuario, senha);// faz a conexão com o banco mediante os dados informados
            stm = (Statement) con.createStatement();// cria o statement da conexao
            return true;// retorna verdadeiro se der certo
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro:\n" + erro.getMessage());
            return false;// apresenta uma mensagem d eerro e retorna falso
        }
    }

    public void desconectar() {
        // método de encerrar a conexão
        try {
            con.close();//encerra a conexao
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro:\n" + erro.getMessage());
        }

    }

    public void testarConexao() throws ClassNotFoundException {
        // método de teste de conexão
        if (conectar()) {
            JOptionPane.showMessageDialog(null, "Conectado");
        } else {
            JOptionPane.showMessageDialog(null, "Desconectado");
        }

    }

}
