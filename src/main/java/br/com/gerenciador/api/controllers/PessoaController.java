package br.com.gerenciador.api.controllers;

import br.com.gerenciador.api.mapper.PessoaMapper;
import br.com.gerenciador.api.model.request.PessoaCreateRequest;
import br.com.gerenciador.api.model.response.PessoaResponse;
import br.com.gerenciador.api.services.PessoaService;
import br.com.gerenciador.api.entities.Pessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaResponse>>  listarPessoas(){
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        List<PessoaResponse> pessoaslistada = PessoaMapper.toResponseList(pessoas);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaslistada);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaResponse> cadastrarPessoa(@Valid @RequestBody PessoaCreateRequest pessoaRequest){
        Pessoa pessoa = PessoaMapper.toEntity(pessoaRequest);
        pessoa = pessoaService.cadastrar(pessoa);
        PessoaResponse pessoaResponse = PessoaMapper.toResponse(pessoa);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);
    }


}
