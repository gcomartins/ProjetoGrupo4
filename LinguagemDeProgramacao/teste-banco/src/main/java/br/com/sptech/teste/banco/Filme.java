package br.com.sptech.teste.banco;

public class Filme {
    private Integer id, anoLancamento;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Filme(Integer id, Integer anoLancamento, String nome) {
        this.id = id;
        this.anoLancamento = anoLancamento;
        this.nome = nome;
    }

    public Filme() {
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Filme{");
        sb.append("id=").append(id);
        sb.append(", anoLancamento=").append(anoLancamento);
        sb.append(", nome=").append(nome);
        sb.append('}');
        return sb.toString();
    }
    
    
}
