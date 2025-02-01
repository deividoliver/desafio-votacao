package br.com.dbserver.votacao.domain.generic;

import java.io.Serializable;

public abstract class GenericDTO implements Serializable {

    protected Long id;

    protected boolean ativo = true;

    protected Long dataCadastro;

    protected Long dataAlteracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Long getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Long dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Long dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

}
