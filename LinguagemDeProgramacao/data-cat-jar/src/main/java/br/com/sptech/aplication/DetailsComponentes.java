/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.sptech.aplication;

import data.cat.banco.ConexaoAzure;
import data.cat.banco.ConexaoMysql;
import data.cat.modal.Componente;
import data.cat.service.ModalServices;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author letic
 */
public class DetailsComponentes extends javax.swing.JFrame {

    List<Componente> listaComponentes;
    List<Componente>  listaComponentesMysql;
    ModalServices modalService;
    ConexaoAzure conexaoazure;
    ConexaoMysql conexaoMysql;
    String nomeMaquina;

    public DetailsComponentes()  {
        initComponents();
        listaComponentes = new ArrayList();
        conexaoazure = new ConexaoAzure();
        conexaoMysql = new ConexaoMysql();
        modalService = new ModalServices();
        try {
            nomeMaquina = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(DetailsComponentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRam = new javax.swing.JLabel();
        lblDisco = new javax.swing.JLabel();
        lblCpu = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        comboRam = new javax.swing.JComboBox<>();
        comboDisco = new javax.swing.JComboBox<>();
        comboCpu = new javax.swing.JComboBox<>();
        lblLimite = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(810, 550));

        lblRam.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblRam.setForeground(new java.awt.Color(22, 26, 29));
        lblRam.setText("RAM");

        lblDisco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDisco.setForeground(new java.awt.Color(22, 26, 29));
        lblDisco.setText("DISCO");

        lblCpu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCpu.setForeground(new java.awt.Color(22, 26, 29));
        lblCpu.setText("CPU");

        jButton1.setBackground(new java.awt.Color(164, 22, 26));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(245, 243, 244));
        jButton1.setText("Inserir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(90, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboRam.setBackground(new java.awt.Color(164, 22, 26));
        comboRam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboRam.setForeground(new java.awt.Color(245, 243, 244));
        comboRam.setMaximumRowCount(5);
        comboRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione --", "20", "30", "40", "50", "60", "70", "80", "90" }));
        comboRam.setMinimumSize(new java.awt.Dimension(150, 35));
        comboRam.setPreferredSize(new java.awt.Dimension(150, 35));
        comboRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRamActionPerformed(evt);
            }
        });

        comboDisco.setBackground(new java.awt.Color(164, 22, 26));
        comboDisco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboDisco.setForeground(new java.awt.Color(245, 243, 244));
        comboDisco.setMaximumRowCount(5);
        comboDisco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione --", "20", "30", "40", "50", "60", "70", "80", "90" }));
        comboDisco.setMinimumSize(new java.awt.Dimension(150, 35));
        comboDisco.setPreferredSize(new java.awt.Dimension(150, 35));
        comboDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDiscoActionPerformed(evt);
            }
        });

        comboCpu.setBackground(new java.awt.Color(164, 22, 26));
        comboCpu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCpu.setForeground(new java.awt.Color(245, 243, 244));
        comboCpu.setMaximumRowCount(5);
        comboCpu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione --", "20", "30", "40", "50", "60", "70", "80", "90" }));
        comboCpu.setMinimumSize(new java.awt.Dimension(150, 35));
        comboCpu.setPreferredSize(new java.awt.Dimension(150, 35));
        comboCpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCpuActionPerformed(evt);
            }
        });

        lblLimite.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLimite.setForeground(new java.awt.Color(22, 26, 29));
        lblLimite.setText("Limite de Alerta");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Subscriber-bro.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblRam)
                            .addGap(71, 71, 71)
                            .addComponent(comboRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(lblLimite))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDisco)
                                .addComponent(lblCpu))
                            .addGap(54, 54, 54)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(lblLimite)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRam)
                            .addComponent(comboRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDisco)
                            .addComponent(comboDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCpu)
                            .addComponent(comboCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(164, 22, 26));
        menu.setForeground(new java.awt.Color(228, 228, 228));
        menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menu.setPreferredSize(new java.awt.Dimension(74, 60));

        jMenu1.setText("File");
        menu.add(jMenu1);

        jMenu2.setText("Edit");
        menu.add(jMenu2);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDiscoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDiscoActionPerformed

    private void comboCpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCpuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCpuActionPerformed

    private void comboRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        System.out.println(comboDisco.getSelectedItem());
        Object ValorDisco = comboDisco.getSelectedItem();
        Object ValorRam =  comboRam.getSelectedItem();
        Object ValorCpu =  comboCpu.getSelectedItem();

        listaComponentes = conexaoazure.getConexaoAzure().query(
                "select C.nome , C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        listaComponentesMysql = conexaoMysql.getConexaoMysql().query(
                "select C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        Integer fkMaquina = listaComponentes.get(0).getFkMaquina();
        Integer fkMaquinaMysql = listaComponentesMysql.get(0).getFkMaquina();

        modalService.insertLimite(ValorDisco, fkMaquina, fkMaquinaMysql, "Disco");
        modalService.insertLimite(ValorRam, fkMaquina, fkMaquinaMysql, "Ram");
        modalService.insertLimite(ValorCpu, fkMaquina, fkMaquinaMysql, "Cpu");
        
        System.out.println("Vlores cadastrados");

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DetailsComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsComponentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailsComponentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCpu;
    private javax.swing.JComboBox<String> comboDisco;
    private javax.swing.JComboBox<String> comboRam;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCpu;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblRam;
    private javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables
}
