package br.com.sptech.teste.banco;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoBanco {
    private JdbcTemplate conexao;
    
    public ConexaoBanco() {
        BasicDataSource dataSource = new BasicDataSource();
        
        dataSource​.setDriverClassName("org.h2.Driver");
        dataSource​.setUrl("jdbc:h2:file:./meu_banco");
        dataSource​.setUsername("sa");
        dataSource​.setPassword("");
        
        conexao = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexao() {
        return conexao;
    }
    
}
