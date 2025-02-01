package br.com.dbserver.votacao.domain.pauta;

import br.com.dbserver.votacao.domain.generic.GenericDTO;

public class PautaDTO extends GenericDTO {

    private String titulo;

    private String descricao;

    private Integer totalVotos;

    private Integer totalVotosSim;

    private Integer totalVotosNao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Integer totalVotos) {
        this.totalVotos = totalVotos;
    }

    public Integer getTotalVotosSim() {
        return totalVotosSim;
    }

    public void setTotalVotosSim(Integer totalVotosSim) {
        this.totalVotosSim = totalVotosSim;
    }

    public Integer getTotalVotosNao() {
        return totalVotosNao;
    }

    public void setTotalVotosNao(Integer totalVotosNao) {
        this.totalVotosNao = totalVotosNao;
    }
}
