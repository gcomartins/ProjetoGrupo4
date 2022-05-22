package data.cat.banco;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoAzure {
     private JdbcTemplate conexaoAzure;
     
    
    public  ConexaoAzure() {
        BasicDataSource dataSource = new BasicDataSource();
        
        
        
          //H2
//        dataSource​.setDriverClassName("org.h2.Driver");;
//        dataSource​.setUrl("jdbc:h2:file:./meu_banco");
//        dataSource​.setUsername("sa");
//        dataSource​.setPassword("");

        
        //AZURE
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://datacat-db.database.windows.net:1433;database=datacat-db;user=_admin@datacat-db;password=2ads$grupo4;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setUsername("_admin");
        dataSource.setPassword("2ads$grupo4");
        
        conexaoAzure = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexaoAzure() {
        return conexaoAzure;
    }
}
