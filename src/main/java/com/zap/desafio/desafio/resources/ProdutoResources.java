package com.zap.desafio.desafio.resources;

import com.zap.desafio.desafio.model.Produto;
import com.zap.desafio.desafio.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@Api(value = "Produto", tags = "Produto")
public class ProdutoResources {

    @Autowired
    ProdutoService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar produto por ID")
    public ResponseEntity<Produto> pesquisar(@PathVariable Integer id){
        Produto obj = service.pesquisar(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ApiOperation(value = "Cadastrar Produto")
    public ResponseEntity<Void> inserir(@Valid @RequestBody Produto obj){
        Produto retorno = service.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(retorno.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ApiOperation(value = "Listagem de produtos")
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = service.listarProdutos();
        return ResponseEntity.ok().body(produtos);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Remover produto")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        Produto obj = service.pesquisar(id);
        service.remover(obj);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Editar Produto")
    public ResponseEntity<Void> update(@Valid @RequestBody Produto obj, @PathVariable Integer id){
        obj.setCodigo(id);
        obj = service.editar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
