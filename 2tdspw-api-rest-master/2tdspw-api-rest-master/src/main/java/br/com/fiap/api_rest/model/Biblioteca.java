package br.com.fiap.api_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationTypr.IDENTITY)
    private Long id;
    private String nome;
    @OneToOne
    @JoinColumn(name ="id_endereco")
    private Endereco endereco;
    @OneToMany
    private List<Livro>livros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}