package br.com.sptech.aplication;

//import data.cat.banco.ConexaoBanco;
//import com.github.britooo.looca.api.core.Looca;
//import com.github.britooo.looca.api.group.discos.Disco;
//import data.cat.modal.Alertas;
//import data.cat.modal.LogApp;
import data.cat.modal.LogApp;
import data.cat.service.AlertasServices;
import data.cat.service.MedidasServices;
import data.cat.service.ModalServices;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
//import java.time.temporal.TemporalQueries;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.json.JSONObject;
import slack.Slack;
// import org.apache.commons.math3.util.Precision;

/**
 *
 * @author guilherme.martin@VALEMOBI.CORP
 */
public class App extends javax.swing.JFrame {

    /**
     * Creates new form App
     */
    public App() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        pnlGeral = new javax.swing.JPanel();
        btnFinalizar = new javax.swing.JButton();
        pnlRam = new javax.swing.JPanel();
        lblRam = new javax.swing.JLabel();
        pnlDisco = new javax.swing.JPanel();
        lblDisco = new javax.swing.JLabel();
        pnlCpu = new javax.swing.JPanel();
        lblCpu = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblUsoDisco = new javax.swing.JLabel();
        lblUsoCpu = new javax.swing.JLabel();
        lblUsoRam = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuDash = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlGeral.setBackground(new java.awt.Color(249, 249, 249));
        pnlGeral.setPreferredSize(new java.awt.Dimension(1218, 680));

        btnFinalizar.setBackground(new java.awt.Color(164, 22, 26));
        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizar.setForeground(new java.awt.Color(249, 249, 249));
        btnFinalizar.setText("Finalizar Aplicação");
        btnFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinalizarMouseExited(evt);
            }
        });
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        pnlRam.setBackground(new java.awt.Color(164, 22, 26));
        pnlRam.setPreferredSize(new java.awt.Dimension(230, 230));

        lblRam.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblRam.setForeground(new java.awt.Color(249, 249, 249));
        lblRam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRam.setText("10.00%");

        javax.swing.GroupLayout pnlRamLayout = new javax.swing.GroupLayout(pnlRam);
        pnlRam.setLayout(pnlRamLayout);
        pnlRamLayout.setHorizontalGroup(
            pnlRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRamLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblRam)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlRamLayout.setVerticalGroup(
            pnlRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRamLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(lblRam)
                .addGap(73, 73, 73))
        );

        pnlDisco.setBackground(new java.awt.Color(164, 22, 26));
        pnlDisco.setPreferredSize(new java.awt.Dimension(230, 230));
        pnlDisco.setLayout(new java.awt.BorderLayout());

        lblDisco.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblDisco.setForeground(new java.awt.Color(249, 249, 249));
        lblDisco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisco.setText("25.00%");
        pnlDisco.add(lblDisco, java.awt.BorderLayout.CENTER);

        pnlCpu.setBackground(new java.awt.Color(164, 22, 26));
        pnlCpu.setPreferredSize(new java.awt.Dimension(230, 230));

        lblCpu.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblCpu.setForeground(new java.awt.Color(249, 249, 249));
        lblCpu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCpu.setText("40.00%");

        javax.swing.GroupLayout pnlCpuLayout = new javax.swing.GroupLayout(pnlCpu);
        pnlCpu.setLayout(pnlCpuLayout);
        pnlCpuLayout.setHorizontalGroup(
            pnlCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCpuLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(lblCpu)
                .addGap(23, 23, 23))
        );
        pnlCpuLayout.setVerticalGroup(
            pnlCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCpuLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblCpu)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        btnIniciar.setBackground(new java.awt.Color(25, 164, 22));
        btnIniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(249, 249, 249));
        btnIniciar.setText("Iniciar Aplicação");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("DISCO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("CPU");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("RAM");

        lblUsoDisco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUsoDisco.setForeground(new java.awt.Color(51, 51, 51));
        lblUsoDisco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsoDisco.setText("Em Uso");

        lblUsoCpu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUsoCpu.setForeground(new java.awt.Color(51, 51, 51));
        lblUsoCpu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsoCpu.setText("Em Uso");
        lblUsoCpu.setToolTipText("");

        lblUsoRam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUsoRam.setForeground(new java.awt.Color(51, 51, 51));
        lblUsoRam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsoRam.setText("Em Uso");
        lblUsoRam.setToolTipText("");

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeralLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(222, 222, 222)
                .addComponent(jLabel3)
                .addGap(219, 219, 219))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeralLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlRam, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(lblUsoRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(86, 86, 86)
                        .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsoDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDisco, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlCpu, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(lblUsoCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(133, 133, 133))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsoDisco)
                    .addComponent(lblUsoCpu)
                    .addComponent(lblUsoRam))
                .addGap(79, 79, 79)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
        );

        menu.setBackground(new java.awt.Color(164, 22, 26));
        menu.setBorder(null);
        menu.setForeground(new java.awt.Color(228, 228, 228));
        menu.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        menu.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        menu.setMinimumSize(new java.awt.Dimension(74, 70));
        menu.setPreferredSize(new java.awt.Dimension(74, 60));

        menuDash.setText("Dashboard");
        menuDash.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menu.add(menuDash);

        menuSair.setText("Sair");
        menuSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuSairMouseExited(evt);
            }
        });
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menu.add(menuSair);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnFinalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseEntered
        btnFinalizar.setBackground(Color.WHITE);
        btnFinalizar.setForeground(new Color(164, 22, 26));
    }//GEN-LAST:event_btnFinalizarMouseEntered

    private void btnFinalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseExited
        btnFinalizar.setBackground(new Color(164, 22, 26));
        btnFinalizar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnFinalizarMouseExited

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseExited
        btnFinalizar.setBackground(new Color(164, 22, 26));
        btnFinalizar.setForeground(Color.WHITE);
    }//GEN-LAST:event_menuSairMouseExited

    private void menuSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseEntered
        btnFinalizar.setBackground(Color.WHITE);
        btnFinalizar.setForeground(new Color(164, 22, 26));
    }//GEN-LAST:event_menuSairMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        IniciarLeitura();
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    public void IniciarLeitura() {
        int periodo = 1000;   // tempo de espera antes da 1ï¿½ execuï¿½ï¿½o da tarefa.
        int interval = 5000;  // intervalo no qual a tarefa serï¿½ executada.
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    lerDados();
                } catch (UnknownHostException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    //Catch para tratamento de erros de requisição do Slack
                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, periodo, interval);
    }

    private void lerDados() throws UnknownHostException, IOException, InterruptedException {
        MedidasServices medidasServices = new MedidasServices();
        ModalServices modalServices = new ModalServices();
        Double discoBanco = modalServices.getLimiteBanco("Disco");
        Double ramBanco = modalServices.getLimiteBanco("Ram");
        Double processadorBanco = modalServices.getLimiteBanco("Cpu");
        Double limiteAlertaRam = ramBanco;
        Double limiteAlertaCpu = processadorBanco;
        Double limiteAlertaDisco = discoBanco;
        AlertasServices alertas = new AlertasServices();

        //Variavel do slack
        String nomeMaquina = InetAddress.getLocalHost().getHostName();
        
        //Objeto para envio de alertas ao Slack
        JSONObject json = new JSONObject();

        modalServices.inserirDisco(medidasServices);
        modalServices.inserirRAM(medidasServices);
        modalServices.inserirProcessador(medidasServices);

        //DISCO
        if (medidasServices.getDiscoEmUso() >= (limiteAlertaDisco * 0.75)) {
            pnlDisco.setBackground(new java.awt.Color(224, 52, 52));
            lblDisco.setText(String.format("%.2f%%", medidasServices.getDiscoEmUso()));
            lblUsoDisco.setText("Crítico");
            //CRITICO
            alertas.inserirAlertas(lblUsoDisco.getText(), "Disco");

            //Envio ao Slack
            json.put("text", "Máquina:" + nomeMaquina + "\nDisco:\nCritico: " + String.format("%.2f%%", medidasServices.getDiscoEmUso()));
            Slack.enviarMensagem(json);

        } else if (medidasServices.getDiscoEmUso() >= (limiteAlertaDisco * 0.5)) {
            pnlDisco.setBackground(new java.awt.Color(233, 173, 84));
            lblDisco.setText(String.format("%.2f%%", medidasServices.getDiscoEmUso()));
            lblUsoDisco.setText("Alerta");
            //ALERTA
            alertas.inserirAlertas(lblUsoDisco.getText(), "Disco");

            //Envio ao Slack
            json.put("text", "Máquina:" + nomeMaquina + "\nDisco:\nAlerta: " + String.format("%.2f%%", medidasServices.getDiscoEmUso()));
            Slack.enviarMensagem(json);

        } else if (medidasServices.getDiscoEmUso() >= (limiteAlertaDisco * 0.25)) {
            pnlDisco.setBackground(new java.awt.Color(233, 209, 84));
            lblDisco.setText(String.format("%.2f%%", medidasServices.getDiscoEmUso()));
            lblUsoDisco.setText("Estável");
        } else {
            pnlDisco.setBackground(new java.awt.Color(87, 175, 80));
            lblDisco.setText(String.format("%.2f%%", medidasServices.getDiscoEmUso()));
            lblUsoDisco.setText("Perfeito");
        }

        //RAM
        if (medidasServices.getRamEmUso() >= (limiteAlertaRam * 0.75)) {
            pnlRam.setBackground(new java.awt.Color(224, 52, 52));
            lblRam.setText(String.format("%.2f%%", medidasServices.getRamEmUso()));
            lblUsoRam.setText("Crítico");
            //CRITICO
            alertas.inserirAlertas(lblUsoRam.getText(), "Ram");

            //Envio ao Slack
            json.put("text", "Máquina:" + nomeMaquina + "\nRAM:\nCritico: " + String.format("%.2f%%", medidasServices.getRamEmUso()));
            Slack.enviarMensagem(json);

        } else if (medidasServices.getRamEmUso() >= (limiteAlertaRam * 0.5)) {
            pnlRam.setBackground(new java.awt.Color(233, 173, 84));
            lblRam.setText(String.format("%.2f%%", medidasServices.getRamEmUso()));
            lblUsoRam.setText("Alerta");
            //ALERTA
            alertas.inserirAlertas(lblUsoRam.getText(), "Ram");

            //Envio ao Slack
            json.put("text", "Máquina:" + nomeMaquina + "\nRAM:\nAlerta: " + String.format("%.2f%%", medidasServices.getRamEmUso()));
            Slack.enviarMensagem(json);

        } else if (medidasServices.getRamEmUso() >= (limiteAlertaRam * 0.25)) {
            pnlRam.setBackground(new java.awt.Color(233, 209, 84));
            lblRam.setText(String.format("%.2f%%", medidasServices.getRamEmUso()));
            lblUsoRam.setText("Estável");
        } else {
            pnlRam.setBackground(new java.awt.Color(87, 175, 80));
            lblRam.setText(String.format("%.2f%%", medidasServices.getRamEmUso()));
            lblUsoRam.setText("Perfeito");
        }

        //CPU
        if (medidasServices.getProcessadorEmUso() >= (limiteAlertaCpu * 0.75)) {
            pnlCpu.setBackground(new java.awt.Color(224, 52, 52));
            lblCpu.setText(String.format("%.2f%%", medidasServices.getProcessadorEmUso()));
            lblUsoCpu.setText("Crítico");
            //CRITICO
            alertas.inserirAlertas(lblUsoCpu.getText(), "Cpu");

            //Envio ao Slack
            json.put("text","Máquina:" + nomeMaquina + "\nCPU:\nCritico: " + String.format("%.2f%%", medidasServices.getProcessadorEmUso()));
            Slack.enviarMensagem(json);

        } else if (medidasServices.getProcessadorEmUso() >= (limiteAlertaCpu * 0.5)) {
            pnlCpu.setBackground(new java.awt.Color(233, 173, 84));
            lblCpu.setText(String.format("%.2f%%", medidasServices.getProcessadorEmUso()));
            lblUsoCpu.setText("Alerta");
            //Alerta
            alertas.inserirAlertas(lblUsoCpu.getText(), "Cpu");

            //Envio ao Slack
            json.put("text", "Máquina:" + nomeMaquina + "\nCPU:\nAlerta: " + String.format("%.2f%%", medidasServices.getProcessadorEmUso()));
            Slack.enviarMensagem(json);

        } else if (medidasServices.getProcessadorEmUso() >= (limiteAlertaCpu * 0.25)) {
            pnlCpu.setBackground(new java.awt.Color(233, 209, 84));
            lblCpu.setText(String.format("%.2f%%", medidasServices.getProcessadorEmUso()));
            lblUsoCpu.setText("Estável");

        } else {
            pnlCpu.setBackground(new java.awt.Color(87, 175, 80));
            lblCpu.setText(String.format("%.2f%%", medidasServices.getProcessadorEmUso()));
            lblUsoCpu.setText("Perfeito");
        }

        //Workbench
        //Logs
        //log.gerarLog(logs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblCpu;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblRam;
    private javax.swing.JLabel lblUsoCpu;
    private javax.swing.JLabel lblUsoDisco;
    private javax.swing.JLabel lblUsoRam;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuDash;
    private javax.swing.JMenu menuSair;
    private javax.swing.JPanel pnlCpu;
    private javax.swing.JPanel pnlDisco;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRam;
    // End of variables declaration//GEN-END:variables

    class RoundedPanel extends JPanel {

        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;

        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
    }

}
