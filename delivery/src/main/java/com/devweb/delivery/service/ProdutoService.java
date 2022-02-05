package com.devweb.delivery.service;

import java.util.List;

import com.devweb.delivery.entity.Produto;
import com.devweb.delivery.exception.NotFoundException;

import com.devweb.delivery.repository.ProdutoRepository;
import com.devweb.delivery.security.AuthenticatedUser;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired AuthenticatedUser aUser;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoByUuid(String uuid) {
        Produto p = produtoRepository.findByUuid(uuid);

        if (p == null) {
            throw new NotFoundException("Produto não encontrado");

        }

        return p;
    }

    public Produto salvar(Produto p) {
        return produtoRepository.save(p);
    }

    public boolean excluir(String uuid) {
        Produto p = this.getProdutoByUuid(uuid);

        if (p != null) {
            try {
                produtoRepository.delete(p);
                return true;
            } catch (EmptyResultDataAccessException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }
    

    public Produto alterar(String uuid, Produto p) {
        Produto produtoAtual = this.getProdutoByUuid(uuid);

        if (produtoAtual != null) {
            BeanUtils.copyProperties(p, produtoAtual, "id", "uuid");
            return produtoRepository.save(produtoAtual);
        }
        return null;
    }


}
