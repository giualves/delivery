package com.devweb.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import com.devweb.delivery.dto.ProdutoDTO;
import com.devweb.delivery.dto.ProdutoInputDTO;
import com.devweb.delivery.dto.ProdutoResumoDTO;
import com.devweb.delivery.entity.Produto;
import com.devweb.delivery.mapper.ProdutoInputMapper;
import com.devweb.delivery.mapper.ProdutoOutputMapper;
import com.devweb.delivery.mapper.ProdutoResumoOutputMapper;
import com.devweb.delivery.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoOutputMapper produtoOutputMapper;
    @Autowired
    private ProdutoInputMapper produtoInputMapper;
    @Autowired
    private ProdutoResumoOutputMapper produtoResumoOutputMapper;

    @GetMapping
    @ResponseBody
    public List<ProdutoResumoDTO> listarTodosProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        List<ProdutoResumoDTO> produtoResumoDTOs = produtoResumoOutputMapper.mapearLista(produtos);
        return produtoResumoDTOs;
    }
    
    @GetMapping("/{uuid}")
    @ResponseBody
    public ProdutoDTO getProdutoById(@PathVariable String uuid) {
        Produto p = produtoService.getProdutoByUuid(uuid);
        ProdutoDTO produtoDTO = produtoOutputMapper.mapearDTO(p);
        return produtoDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    private ProdutoDTO adicionar(@RequestBody @Valid ProdutoInputDTO produtoInputDTO) {
        Produto p = produtoInputMapper.mapearEntity(produtoInputDTO);
        p = produtoService.salvar(p);
        ProdutoDTO produtoDTO = produtoOutputMapper.mapearDTO(p);
        return produtoDTO;
    }

    @PutMapping("/{uuid}")
    @ResponseBody
    private ProdutoDTO alterar(@PathVariable String uuid, @Valid @RequestBody ProdutoInputDTO produtoInputDTO) {
        Produto p = produtoInputMapper.mapearEntity(produtoInputDTO);
        p = produtoService.alterar(uuid, p);
        ProdutoDTO produtoDTO = produtoOutputMapper.mapearDTO(p);
        return produtoDTO;

    }

    @DeleteMapping("/{uuid}")
    private ResponseEntity<Produto> deletar(@PathVariable String uuid) {
        if (produtoService.excluir(uuid)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

}
