package com.zap.desafio.desafio.service;

import com.zap.desafio.desafio.model.Produto;
import com.zap.desafio.desafio.repositories.ProdutoRepository;
import com.zap.desafio.desafio.service.exceptions.ObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Produto pesquisar(Integer id){
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontrado
                ("Objeto não encontrado, ID: " + id + ". Tipo: " + Produto.class.getName()));
    }

    public Produto inserir(Produto obj) {
        return repository.saveAndFlush(obj);
    }

    public List<Produto> listarProdutos(){
        return repository.findAll();
    }

    public void remover(Produto obj) {
        repository.delete(obj);
    }

    public Produto editar(Produto obj) {
        return repository.saveAndFlush(obj);
    }
}
