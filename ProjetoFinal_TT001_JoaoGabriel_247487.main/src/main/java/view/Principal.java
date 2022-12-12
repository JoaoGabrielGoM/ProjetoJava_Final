/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Controller;
import static controller.Controller.jRadioButtonClientesSelecionado;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AnimalDAO;
import model.ClienteDAO;
import model.ConsultaDAO;
import model.ExameDAO;
import model.FuncionarioDAO;

/**
 *
 * @author joaom
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    public void myInitComponents() throws ParseException {
        Controller.setTableModel(jTable1, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
        Controller.jRadioButtonClientesSelecionado(jTable1);
        jRadioButton1.setSelected(true);
        //Controller.setTextFields(NomeCli_TextField, NomeAnim_TextField);
        
        
    }
    
    public Principal() throws ParseException {
        initComponents();
        this.myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        CadastroCliente_Panel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CadastroCliente_Panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Veterinário"));
        CadastroCliente_Panel1.setToolTipText("");

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Deletar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Qual tabela deseja cadastrar/consultar?"));

        jRadioButton1.setText("Cliente");
        jRadioButton1.setFocusable(false);
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jRadioButton1);

        jRadioButton2.setText("Funcionários");
        jRadioButton2.setFocusable(false);
        jRadioButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jRadioButton2);

        jRadioButton3.setText("Exames");
        jRadioButton3.setFocusable(false);
        jRadioButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jRadioButton3);

        jRadioButton5.setText("Animais");
        jRadioButton5.setFocusable(false);
        jRadioButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRadioButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jRadioButton5);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Cadastro", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Consulta", jScrollPane2);

        javax.swing.GroupLayout CadastroCliente_Panel1Layout = new javax.swing.GroupLayout(CadastroCliente_Panel1);
        CadastroCliente_Panel1.setLayout(CadastroCliente_Panel1Layout);
        CadastroCliente_Panel1Layout.setHorizontalGroup(
            CadastroCliente_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroCliente_Panel1Layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(262, 262, 262))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CadastroCliente_Panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
            .addGroup(CadastroCliente_Panel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        CadastroCliente_Panel1Layout.setVerticalGroup(
            CadastroCliente_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroCliente_Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CadastroCliente_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CadastroCliente_Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CadastroCliente_Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton5.isSelected()){
            jRadioButton2.setSelected(false);
            jRadioButton1.setSelected(false);
           
            jRadioButton3.setSelected(false);
        }

        Controller.jRadioButtonAnimaisSelecionado(jTable1);

    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton3.isSelected()){
            jRadioButton2.setSelected(false);
            jRadioButton1.setSelected(false);
            
            jRadioButton5.setSelected(false);
        }

        Controller.jRadioButtonExameSelecionado(jTable1);

    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton2.isSelected()){
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
            
            jRadioButton5.setSelected(false);

        }

        Controller.jRadioButtonFuncionarioSelecionado(jTable1);

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:

        //Botão Clientes e Pets

        if (jRadioButton1.isSelected()){
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton5.setSelected(false);

        }

        //Controller.setTableModel(jTable1, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
        jRadioButtonClientesSelecionado(jTable1);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        //botão delete
        if (jTable1.getModel() instanceof ClienteTableModel) {
            ((ClienteTableModel)jTable1.getModel()).removeItem(jTable1.getSelectedRow());
            if (Controller.getClienteSelecionado() != null) {
                Controller.apagaCliente(Controller.getClienteSelecionado());
                //jTextField1.setText("");
            }
        }
        
        if (jTable1.getModel() instanceof AnimalTableModel) {
            ((AnimalTableModel)jTable1.getModel()).removeItem(jTable1.getSelectedRow());
            if (Controller.getAnimalSelecionado() != null) {
            Controller.apagaAnimal(Controller.getAnimalSelecionado());
                //jTextField1.setText("");
            }
        }
        
        if (jTable1.getModel() instanceof ExameTableModel) {
            ((ExameTableModel)jTable1.getModel()).removeItem(jTable1.getSelectedRow());
            Controller.apagaExame(Controller.getExameSelecionado());
        }
        
        if (jTable1.getModel() instanceof ConsultaTableModel) {
            ((ConsultaTableModel)jTable1.getModel()).removeItem(jTable1.getSelectedRow());
            Controller.apagaConsulta(Controller.getConsultaSelecionado());
        }
        

        if (jTable1.getModel() instanceof FuncionarioTableModel) {
            ((FuncionarioTableModel)jTable1.getModel()).removeItem(jTable1.getSelectedRow());
            Controller.apagaFuncionario(Controller.getFuncionarioSelecionado());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        //JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");

        try {
            // Adicionar novos registros
            Controller.adicionarEntidade(jTable1);
        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        if (jTable1.getModel() instanceof ClienteTableModel){

            ((GenericTableModel)jTable1.getModel()).addItem(Controller.adicionaCliente("asdas",0, "jhkjhj"));

        }
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        Controller.setSelected(((GenericTableModel) jTable1.getModel()).getItem(jTable1.getSelectedRow()));
    }//GEN-LAST:event_jTable1MousePressed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

        // TODO add your handling code here:
        if (jTabbedPane1.isEnabled()){
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton1.setSelected(false);
            jRadioButton5.setSelected(false);

        }
        
        Controller.jRadioButtonConsultasSelecionado(jTable2);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CadastroCliente_Panel1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
