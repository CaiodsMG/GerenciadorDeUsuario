package br.com.gerenciador.api.model.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class PessoaResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private int idade;

    public PessoaResponse() {
    }

    public PessoaResponse(Long id, String nome, String email, String telefone, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getIdade() {
        return idade;
    }
}
