/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.service;

import br.com.sptech.login.java.swing.ConexaoBanco;
import data.cat.modal.LogApp;
import java.net.UnknownHostException;

/**
 *
 * @author lmmelo1
 */
public class AlertasServices {
    
    ConexaoBanco conexao;
    MedidasServices medidaslServices;
    LogApp log;
    
    public AlertasServices() throws UnknownHostException 
    {
        medidaslServices = new MedidasServices();
        conexao = new ConexaoBanco();
        log = new LogApp();
    }
    
    public void inserirAlertas(String categoria, Integer idLog ) 
    {
        conexao.getConexao().update("insert into tbAlertas"
                + " (fkLog, categoria, descrição) values(?, ?, '*******')", 
                idLog, categoria);
    }
    
    
    
    
}
