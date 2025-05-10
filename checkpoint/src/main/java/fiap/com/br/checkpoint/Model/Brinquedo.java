package fiap.com.br.checkpoint.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "T_JA_BRINQUEDOS")
public class Brinquedo {

    @Id
    @GeneratedValue(generator = "T_JA_BRINQUEDOS_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @NotBlank(message = "Campo de 'NOME' é obrigatório")
    @Column(name = "NOME", nullable = false)
    private String nome;

    @NotBlank(message = "Campo de 'TIPO' é obrigatório")
    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @NotNull(message = "Campo de 'CLASSIFICACAO' é obrigatório")
    @Column(name = "CLASSIFICACAO", nullable = false)
    private int classificacao;

    @Column(name = "TAMANHO")
    private double tamanho;

    @NotNull(message = "Campo de 'PRECO' é obrigatório")
    @Column(name = "PRECO", precision = 2)
    private double preco;

    public Brinquedo(int id, String nome, String tipo, int classificacao, double tamanho, double preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public Brinquedo(String nome, String tipo, int classificacao, double tamanho, double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public Brinquedo(int id, String nome, String tipo, int classificacao, double preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.preco = preco;
    }

    public Brinquedo() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
