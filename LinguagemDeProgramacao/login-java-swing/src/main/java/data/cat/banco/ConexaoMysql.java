/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.banco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author lmmelo1
 */
public class ConexaoMysql {
    private JdbcTemplate conexaoMysql;
    
    
    public ConexaoMysql(){
        BasicDataSource dataSource = new BasicDataSource();
        
        
        //mySQL
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://localhost:3306/Grupo4?useSSL=false&useUnicode=true&serverTimezone=GMT-3");
        dataSource​.setUsername("root");
        dataSource​.setPassword("Lucas7968");
        
         conexaoMysql = new JdbcTemplate(dataSource);
    }
    
     public JdbcTemplate getConexaoMysql() {
        return conexaoMysql;
    }
    
}
