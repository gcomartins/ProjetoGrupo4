package br.com.sptech.teste.banco;
    
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class App {
    public static void main(String[] args) {
        ConexaoBanco conexao = new ConexaoBanco();
        
        conexao.getConexao().execute("drop table if exists filme");
        
        conexao.getConexao().execute("create table filme("
            + "id int primary key auto_increment,"
            + "nome varchar(255),"
            + "ano_lancamento int"
            + ")");  
        
        conexao.getConexao().update("insert into filme "
            +"values(null, 'Shrek 3', 2003)");
        
        conexao.getConexao().update("insert into filme "
            +"values(null, ?, ?)", "Shrek 2", 2004);
        
        String nomeFilme = "Shrek";
        Integer ano = 2000;
        
        conexao.getConexao().update("insert into filme "
            +"values(null, ?, ?)", nomeFilme, ano);
        
        List<Map<String, Object>> filmes = conexao
                .getConexao()
                .queryForList("select * from filme");
        
        System.out.println(filmes);
        
        //BEAN PRECISA DE UM CONSTRUTOR VAZIO NA CLASSE
        List<Filme> listaDeFilmes = conexao
                .getConexao()
                .query("select * from filme", new BeanPropertyRowMapper(Filme.class));
        
        System.out.println(listaDeFilmes);
        
        conexao.getConexao().update("update filme "
        + "set nome = 'Cinderela 18' where id = 2");
        
        List<Filme> listaDeFilmes2 = conexao
                .getConexao()
                .query("select * from filme", new BeanPropertyRowMapper(Filme.class));
        
        System.out.println(listaDeFilmes2);
        
        conexao.getConexao().execute("delete from filme where id = 1");
        
        List<Filme> listaDeFilmes3 = conexao
                .getConexao()
                .query("select * from filme", new BeanPropertyRowMapper(Filme.class));
        
        System.out.println(listaDeFilmes3);
        
    }
}
