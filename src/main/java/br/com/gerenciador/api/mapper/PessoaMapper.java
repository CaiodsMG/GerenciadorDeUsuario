package br.com.gerenciador.api.mapper;

import br.com.gerenciador.api.entities.Pessoa;
import br.com.gerenciador.api.model.request.PessoaCreateRequest;
import br.com.gerenciador.api.model.response.PessoaResponse;

import java.util.ArrayList;
import java.util.List;

public abstract class PessoaMapper {

    public static Pessoa toEntity(PessoaCreateRequest pessoaRequest){
        return new Pessoa(pessoaRequest.getNome(), pessoaRequest.getEmail(), pessoaRequest.getTelefone(), pessoaRequest.getIdade());
    }

    public static PessoaResponse toResponse(Pessoa pessoa){
        return new PessoaResponse(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone(), pessoa.getIdade());
    }

    public static List<PessoaResponse> toResponseList(List<Pessoa> pessoas){
        List<PessoaResponse> pessoasResponseList = new ArrayList<>();

        for (Pessoa pessoa:pessoas){
            PessoaResponse pessoaResponse = new PessoaResponse();
            pessoaResponse = toResponse(pessoa);
            pessoasResponseList.add(pessoaResponse);
        }

        return pessoasResponseList;
    }

}
