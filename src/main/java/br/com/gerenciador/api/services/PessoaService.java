package br.com.gerenciador.api.services;

import br.com.gerenciador.api.entities.Pessoa;
import br.com.gerenciador.api.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }


    public Pessoa cadastrar(Pessoa pessoa) {
        LocalDateTime dataAtual = LocalDateTime.now();
        pessoa.setDataCriacao(dataAtual);
        pessoa.setDataAtualizacao(dataAtual);
        return pessoaRepository.save(pessoa);
    }
}
