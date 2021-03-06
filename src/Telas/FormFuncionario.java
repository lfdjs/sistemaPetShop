/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import DAO.FuncionarioDAO;
import DAO.TipoServicoDAO;
import Entidades.TipoServico;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Silva
 */
public class FormFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form Funcionario
     */
    public FormFuncionario() throws SQLException {
        initComponents();
        exibirTipoServico();//Exibe o tipo do serviço
        exibirFunc();// Exibe a tabela dos funcionários cadatsrados
        btnAlterar.setVisible(false);// Esconde o botão alterar
        btnExcluir.setVisible(false);// Esconde o botão Excluir
        btnCadastrar.setVisible(true);// Mostra o botão Cadastrar
        idFunc.setVisible(false);// esconde a label do id
    }

    Entidades.Funcionario func = new Entidades.Funcionario();// Instancia a classe Funcionario, delegando os metodos getters e setters
    FuncionarioDAO funcdao = new FuncionarioDAO();// Instancia a classe DAO, delegando os métodos crud

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbSexo = new javax.swing.JLabel();
        lbCPF = new javax.swing.JLabel();
        lbRG = new javax.swing.JLabel();
        lbTipoServico = new javax.swing.JLabel();
        tbNome = new javax.swing.JTextField();
        tbRG = new javax.swing.JTextField();
        tbCPF = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        cbxSexo = new javax.swing.JComboBox<>();
        cbxTipoServico = new javax.swing.JComboBox<>();
        cbxTipoFunc = new javax.swing.JComboBox<>();
        lbTipoFunc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFunc = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        idFunc = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("Cadastro de Funcionários");

        lbNome.setText("Nome:");

        lbSexo.setText("Sexo");

        lbCPF.setText("CPF:");

        lbRG.setText("RG:");

        lbTipoServico.setText("Tipo de Serviço");

        btnCadastrar.setBackground(new java.awt.Color(0, 153, 153));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(0, 153, 153));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        cbxTipoFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banhista", "Veterinario", "Recepcionista", "Tosador" }));

        lbTipoFunc.setText("Tipo de Funcionário");

        tblFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nome do Funcionário", "CPF", "RG", "Sexo", "Tipo de Funcionario", "idTipoServico"
            }
        ));
        tblFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFunc);

        btnExcluir.setBackground(new java.awt.Color(0, 153, 153));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        idFunc.setText("id");

        btnVoltar.setBackground(new java.awt.Color(0, 153, 153));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar a Tela Inicial");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/vet.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 294, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTipoServico)
                                    .addComponent(lbTipoFunc)
                                    .addComponent(lbSexo)
                                    .addComponent(lbRG))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTipoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTipoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome)
                                    .addComponent(lbCPF))
                                .addGap(118, 118, 118)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbRG, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idFunc)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCPF)
                            .addComponent(tbCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRG)
                            .addComponent(tbRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSexo))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTipoFunc)
                            .addComponent(cbxTipoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTipoServico)
                            .addComponent(cbxTipoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCadastrar)
                            .addComponent(btnAlterar)
                            .addComponent(btnExcluir))
                        .addGap(39, 39, 39)
                        .addComponent(idFunc))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // Ação do botão cadastrar:
        try {
            //Verifica se os campos estão em branco e em caso positivo retorna uma mensagem solicitando o preenchimento e focando no respectivo campo
            if (tbNome.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Favor, digite o nome do Funcionário");
                tbNome.grabFocus();
            } else if (tbCPF.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Favor, digite o CPF do funcionário");
                tbCPF.grabFocus();
            } else if (tbRG.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Favor, digite o RG do Funcionário");
                tbCPF.grabFocus();
            } else {
                // Pega os dados informados e efetua a função de cadastrar
                func.setNome(tbNome.getText());
                func.setCpf(Long.parseLong(tbCPF.getText()));
                func.setRg(Integer.parseInt(tbRG.getText()));
                func.setSexo((String) cbxSexo.getSelectedItem());
                func.setTipoFunc((String) cbxTipoFunc.getSelectedItem());
                /* 
                Como não encontramos nenhuma maneira breve de mostrar apenas
                o nome mas ter como valor setado o id, fizemos esta gambiarra intergalática 
                pra fazer isso funcionar, convertendo um cast de string de um combobox em int
                por favor, peço para que não se assustem.
                 */
                func.setIdTipoServico(Integer.parseInt((String) String.valueOf(cbxTipoServico.getSelectedItem()).substring(0, 1)));
                funcdao.cadastrar(func);//metodo delegado da classe dao, que faz o cadatsro
                JOptionPane.showMessageDialog(null, "Funcionário " + func.getNome() + " cadastrado com sucesso!");
                exibirFunc();// Atualiza a agenda
                limparCampos();// Limpa os campos preenchidos em branco
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: " + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void tblFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncMouseClicked
        // Ação de clicar em um dos itens da tabela:

        exibirFuncFiltro();// Seta os dados nos campos de texto e nos comboboxes
        btnCadastrar.setVisible(false); // Esconde o botão de cadastrar
        btnAlterar.setVisible(true);// Mostra o botão de Alterar
        btnExcluir.setVisible(true);// Mostra o botão de Excluir
    }//GEN-LAST:event_tblFuncMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // Ação de clicar na area em branco do formulário:
        limparCampos();// limpa os campos preenchidos
        btnAlterar.setVisible(false);// Esconde o botão de Alterar
        btnExcluir.setVisible(false);// Esconde o botão de Excluir
        btnCadastrar.setVisible(true);// Mostra o botão de Cadatsrar
    }//GEN-LAST:event_formMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         // Ação do botão de excluir:

        //Questiona ao usuário se deseja realmente excluir o cadastro
        int conf = JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir o cadastro?", "Atenção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (conf == 0) {
            //Caso positivo
            func.setIdFuncionario(Integer.parseInt(idFunc.getText()));// Seta o id do funcionario de acordo com o campo selecionado da tabela, no label id, que está escondido.
            try {
                funcdao.excluir(func);//Chama o método excluir, delegado da classe dao
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
                limparCampos();// Limpa os campos setados
                exibirFunc();// Atualiza a tabela
                btnAlterar.setVisible(false);// Esconde o botão de alterar
                btnExcluir.setVisible(false);// Esconde o botão de Excluir
                btnCadastrar.setVisible(true);// Mostra o Botão de Cadastrar
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "O procedimento de exclusão foi cancelado!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // Ação do botão de alterar:

        //Pega os dados dos campos que foram alterados
        func.setNome(tbNome.getText());
        func.setCpf(Long.parseLong(tbCPF.getText()));
        func.setRg(Integer.parseInt(tbRG.getText()));
        func.setSexo((String) cbxSexo.getSelectedItem());
        func.setTipoFunc((String) cbxTipoFunc.getSelectedItem());
        func.setIdTipoServico(Integer.parseInt((String) String.valueOf(cbxTipoServico.getSelectedItem()).substring(0, 1)));
        func.setIdFuncionario(Integer.parseInt(idFunc.getText()));
        try {
            //Executa o método alterar, delegado da classe dao
            funcdao.alterar(func);
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso");
            limparCampos();// Limpa os campos setados
            exibirFunc();// Atualiza a tabela
            btnAlterar.setVisible(false);// Esconde o botão alterar
            btnExcluir.setVisible(false);// Esconde o botão Excluir
            btnCadastrar.setVisible(true);// Exibe o botão Cadastrar
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // Ação do botão de voltar a tela inicial:
        TelaInicial inicio = new TelaInicial();// Instancia a classe tela inicial
        this.setVisible(false);// fecha a tela atual
        inicio.setVisible(true);// Mosra a tela inicial
    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormFuncionario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void exibirTipoServico() throws SQLException {
        try {
            //exibe os tipos de serviço no combobox
            TipoServicoDAO tiposervicodao = new TipoServicoDAO();// Instancia a classe dao
            for (TipoServico tiposerv : tiposervicodao.tipservs()) {
                cbxTipoServico.addItem(tiposerv.toString());// Adiciona os nomes dos tipos de serviços no combobox, mediante consulta realizada

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu o seguinte erro: " + e.getMessage());
        }
    }

    private void exibirFunc() throws SQLException {
        // Declara uma nova defaulttablemodel, que é atribuida ao modelo da tabela criada na interface gráfica
        DefaultTableModel tabelaResp = (DefaultTableModel) tblFunc.getModel();

        tabelaResp.setRowCount(0);//Seta as linhas em 0

        for (Iterator<Object> it = funcdao.exibir().iterator(); it.hasNext();) {
            //Iterador, que tem como argumentos o metodo exibir funcionario, e adiciona dados a cada linha constante na tabela agenda
            Entidades.Funcionario func = (Entidades.Funcionario) it.next();//Cast de Funcionario no iterador
            tabelaResp.addRow(new Object[]{
                func.getIdFuncionario(),
                func.getNome(),
                func.getCpf(),
                func.getRg(),
                func.getSexo(),
                func.getTipoFunc(),
                func.getIdTipoServico()
            });

        }
    }

    private void exibirFuncFiltro() {
        //Seta os itens nos campos de texto e comboboxes de acordo com o item selecionado da tabela
        tbNome.setText(tblFunc.getValueAt(tblFunc.getSelectedRow(), 1).toString());
        tbCPF.setText(tblFunc.getValueAt(tblFunc.getSelectedRow(), 2).toString());
        tbRG.setText(tblFunc.getValueAt(tblFunc.getSelectedRow(), 3).toString());
        cbxSexo.setSelectedItem(tblFunc.getValueAt(tblFunc.getSelectedRow(), 4).toString());
        cbxTipoFunc.setSelectedItem(tblFunc.getValueAt(tblFunc.getSelectedRow(), 5).toString());
        cbxTipoServico.setSelectedItem(tblFunc.getValueAt(tblFunc.getSelectedRow(), 6).toString());
        idFunc.setText(tblFunc.getValueAt(tblFunc.getSelectedRow(), 0).toString());
    }

    private void limparCampos() {
        //Limpa os campos de texto preenchidos
        tbNome.setText("");
        tbCPF.setText("");
        tbRG.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxTipoFunc;
    private javax.swing.JComboBox<String> cbxTipoServico;
    private javax.swing.JLabel idFunc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbRG;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbTipoFunc;
    private javax.swing.JLabel lbTipoServico;
    private javax.swing.JTextField tbCPF;
    private javax.swing.JTextField tbNome;
    private javax.swing.JTextField tbRG;
    private javax.swing.JTable tblFunc;
    // End of variables declaration//GEN-END:variables
}
