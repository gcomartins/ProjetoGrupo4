/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package teste.edicao.componente;

import br.com.sptech.aplication.App;
import br.com.sptech.aplication.OptionsGui;
import data.cat.banco.ConexaoAzure;
import data.cat.banco.ConexaoMysql;
import data.cat.modal.Componente;
import data.cat.modal.Maquina;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;


/**
 *
 * @author letic
 */
public class FormComponentes extends javax.swing.JFrame {
    
    int botaoEscolhido = 0;
    
    String nomeMaquina;
    
    /**
     * Creates new form NewJFrame
     */
    public FormComponentes() throws UnknownHostException {
        this.nomeMaquina = InetAddress.getLocalHost().getHostName();
        initComponents();
        
    }
    
    ConexaoAzure azure = new ConexaoAzure();
//    ConexaoMysql mysql = new ConexaoMysql();
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        pnlFundo = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblLimiteAlerta = new javax.swing.JLabel();
        lblFkMaquina = new javax.swing.JLabel();
        txtLimiteAlerta = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtFkMaquina = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComponentes = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuGeral = new javax.swing.JMenu();
        menuOptionGUI = new javax.swing.JMenuItem();
        menuDash = new javax.swing.JMenuItem();
        menuOpcoes = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro");

        pnlFundo.setBackground(new java.awt.Color(245, 243, 244));
        pnlFundo.setPreferredSize(new java.awt.Dimension(1218, 680));

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(22, 26, 29));
        lblId.setText("ID");

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(22, 26, 29));
        lblNome.setText("Nome");

        lblLimiteAlerta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLimiteAlerta.setForeground(new java.awt.Color(22, 26, 29));
        lblLimiteAlerta.setText("Limite de Alerta");

        lblFkMaquina.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFkMaquina.setForeground(new java.awt.Color(22, 26, 29));
        lblFkMaquina.setText("Máquina");

        txtLimiteAlerta.setForeground(new java.awt.Color(69, 73, 74));
        txtLimiteAlerta.setPreferredSize(new java.awt.Dimension(260, 30));

        txtNome.setForeground(new java.awt.Color(69, 73, 74));
        txtNome.setPreferredSize(new java.awt.Dimension(260, 30));

        txtId.setForeground(new java.awt.Color(69, 73, 74));
        txtId.setPreferredSize(new java.awt.Dimension(64, 30));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtFkMaquina.setForeground(new java.awt.Color(69, 73, 74));
        txtFkMaquina.setPreferredSize(new java.awt.Dimension(260, 30));
        txtFkMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFkMaquinaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(22, 26, 29));
        jLabel5.setText("Dados do Componente");

        tblComponentes.setForeground(new java.awt.Color(69, 73, 74));
        tblComponentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Limite de Alerta", "Máquina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComponentes);

        btnAdd.setBackground(new java.awt.Color(164, 22, 26));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 238, 239));
        btnAdd.setText("Adicionar");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setMaximumSize(new java.awt.Dimension(81, 28));
        btnAdd.setMinimumSize(new java.awt.Dimension(81, 28));
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 28));

        btnEditar.setBackground(new java.awt.Color(164, 22, 26));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 238, 239));
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setMaximumSize(new java.awt.Dimension(81, 28));
        btnEditar.setMinimumSize(new java.awt.Dimension(81, 28));
        btnEditar.setPreferredSize(new java.awt.Dimension(100, 28));

        javax.swing.GroupLayout pnlFundoLayout = new javax.swing.GroupLayout(pnlFundo);
        pnlFundo.setLayout(pnlFundoLayout);
        pnlFundoLayout.setHorizontalGroup(
            pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFundoLayout.createSequentialGroup()
                .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFundoLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel5))
                    .addGroup(pnlFundoLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFundoLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLimiteAlerta)
                            .addComponent(lblNome)
                            .addComponent(lblId)
                            .addComponent(lblFkMaquina))
                        .addGap(37, 37, 37)
                        .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFkMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLimiteAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        pnlFundoLayout.setVerticalGroup(
            pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFundoLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFundoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(59, 59, 59)
                        .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId))
                        .addGap(35, 35, 35)
                        .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome))
                        .addGap(36, 36, 36)
                        .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLimiteAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLimiteAlerta))
                        .addGap(35, 35, 35)
                        .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFkMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFkMaquina))
                        .addGap(70, 70, 70)
                        .addGroup(pnlFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(164, 22, 26));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu.setPreferredSize(new java.awt.Dimension(70, 55));

        menuGeral.setForeground(new java.awt.Color(164, 22, 26));
        menuGeral.setText("Menu");
        menuGeral.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menuGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuGeralMouseClicked(evt);
            }
        });

        menuOptionGUI.setText("Menu");
        menuOptionGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOptionGUIActionPerformed(evt);
            }
        });
        menuGeral.add(menuOptionGUI);

        menuDash.setText("Dashboard");
        menuDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDashActionPerformed(evt);
            }
        });
        menuGeral.add(menuDash);

        menu.add(menuGeral);

        menuOpcoes.setForeground(new java.awt.Color(164, 22, 26));
        menuOpcoes.setText("Opções");
        menuOpcoes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuSair);

        menu.add(menuOpcoes);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       
        
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtFkMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFkMaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFkMaquinaActionPerformed

    private void menuDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashActionPerformed
        new App().setVisible(true); 
    }//GEN-LAST:event_menuDashActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuOptionGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOptionGUIActionPerformed
        new OptionsGui().setVisible(true);
    }//GEN-LAST:event_menuOptionGUIActionPerformed

    private void menuGeralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGeralMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuGeralMouseClicked

    public void preencherTabela(String Sql) {
        List<Componente> dados = new ArrayList();
        String[] colunas = new String[]{"idFuncionario", "nomeFuncionario", "emailFuncionario", "cargo"};
        
        List<Maquina> listaMaquina = new ArrayList();
        
        List<Componente> listaComponentes = new ArrayList();
        
        Integer idMaquina;

                    listaMaquina = azure.getConexaoAzure().query("select idMaquina from tbMaquina where hostName = ' " + nomeMaquina + "'", 
                    new BeanPropertyRowMapper<>(Maquina.class));
            
            idMaquina = listaMaquina.get(0).getIdMaquina();
            
            //Esse método espera que eu entre com uma String, que é justamente o comando SQL
            listaComponentes = azure.getConexaoAzure().query("select * from tbComponentes where fkMaquina = ' " + idMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));
                for (int i = 0; i < listaComponentes.size(); i++) {
                        dados.add(listaComponentes.get(i));
                }
                
                
        Tabela tabela = new Tabela((ArrayList) dados, colunas);
        
        tblComponentes.setModel((TableModel) tabela);
        
        tblComponentes.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblComponentes.getColumnModel().getColumn(0).setResizable(false);
        
        tblComponentes.getColumnModel().getColumn(1).setPreferredWidth(165);
        tblComponentes.getColumnModel().getColumn(1).setResizable(false);
        
        tblComponentes.getColumnModel().getColumn(2).setPreferredWidth(180);
        tblComponentes.getColumnModel().getColumn(2).setResizable(false);
        
        tblComponentes.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblComponentes.getColumnModel().getColumn(3).setResizable(false);
        
        tblComponentes.getTableHeader().setReorderingAllowed(false);
        tblComponentes.setAutoResizeMode(tblComponentes.AUTO_RESIZE_OFF);
        tblComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
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
            java.util.logging.Logger.getLogger(FormComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new FormComponentes().setVisible(true);
                FormComponentes form = null;
                try {
                    form = new FormComponentes();
                } catch (UnknownHostException ex) {
                    Logger.getLogger(FormComponentes.class.getName()).log(Level.SEVERE, null, ex);
                }
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFkMaquina;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLimiteAlerta;
    private javax.swing.JLabel lblNome;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuDash;
    private javax.swing.JMenu menuGeral;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuOptionGUI;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JPanel pnlFundo;
    private javax.swing.JTable tblComponentes;
    private javax.swing.JTextField txtFkMaquina;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLimiteAlerta;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
