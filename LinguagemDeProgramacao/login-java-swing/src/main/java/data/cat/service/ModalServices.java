/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.service;

import br.com.sptech.login.java.swing.ConexaoBanco;
import data.cat.modal.Componente;
import data.cat.modal.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author lmmelo1
 */
public class ModalServices {

    ConexaoBanco conexao = new ConexaoBanco();
    MedidasServices medidasServices = new MedidasServices();
    Date dataHora = new Date();
    
    public void inserirDisco(MedidasServices medidasServices){
        conexao.getConexao().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, 5)", medidasServices.getDiscoEmUso(), dataHora);
    }
    
    public void inserirRAM(MedidasServices medidasServices){
        conexao.getConexao().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, 4)", medidasServices.getRam(), dataHora);
    }
    
    public void inserirProcessador(MedidasServices medidasServices){
        conexao.getConexao().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, 6)", medidasServices.getProcessador(), dataHora);
    }
    
    

    List<Componente> listaUsuarios = new ArrayList<>();

    public Integer getDiscoBanco() {

        listaUsuarios = conexao.getConexao().query(
                "select * from tbComponentes where email = 'Disco'",
                new BeanPropertyRowMapper<>(Componente.class));
        
        for (int i = 0; i < 10; i++) {
            
        }
        
        

        return 0;
    }

}
