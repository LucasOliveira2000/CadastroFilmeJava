package br.com.lucas.screenmatch.domain.filme;


import br.com.lucas.screenmatch.filme.DadosAlteracaoFilme;
import jakarta.persistence.*;

@Entity  //lá no banco de dados vai ter uma tabela indicando
@Table(name = "filmes")
public class Filme {

    @Id  // Diz que "id" é a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Dizer para que o banco de dados que vai gerar o id e não a aplicação
    private Long id;
    private String nome;
    private Integer duracaoEmMinutos;
    private Integer anoLancamento;
    private String categoria;

    public Filme(DadosCadastroFilme dados){ //construtor que recebe como parametro o Record
        this.nome = dados.nome();
        this.duracaoEmMinutos = dados.duracao();
        this.anoLancamento = dados.ano();
        this.categoria = dados.categoria();
    }

    public Filme(){

    }


    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                ", categoria ='" + categoria + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void atualizaDados(DadosAlteracaoFilme dados) {
        this.nome = dados.nome();
        this.duracaoEmMinutos = dados.duracao();
        this.anoLancamento = dados.ano();
        this.categoria = dados.categoria();
    }
}
