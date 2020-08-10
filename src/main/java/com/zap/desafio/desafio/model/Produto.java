package com.zap.desafio.desafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPRODUTO")
    private Integer codigo;

    @Length(min = 1, max = 255, message = "Nome do produto deve ser informado e ter no máximo 255 caracteres.")
    @Column(name = "NOME", nullable = false)
    private String nome;

    @Length(max = 255, message = "Descrição deve ter no máximo 255 caracteres.")
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull(message = "Preço de produto deve ser informado.")
    @Column(name = "PRECO")
    private BigDecimal preco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_GRAVACAO")
    private Date dataGavacao;

    public Produto() {
        this.dataGavacao = new Date();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDataGavacao() {
        return dataGavacao;
    }

}
