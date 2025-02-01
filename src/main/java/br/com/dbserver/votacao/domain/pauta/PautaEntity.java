package br.com.dbserver.votacao.domain.pauta;

import br.com.dbserver.votacao.domain.generic.GenericEntity;
import br.com.dbserver.votacao.domain.sessaoVoto.SessaoVotoEntity;
import br.com.dbserver.votacao.domain.voto.VotoEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pauta")
@AttributeOverride(name = "id", column = @Column(name = "id_pauta"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "sequence_pauta", allocationSize = 1)
public class PautaEntity extends GenericEntity {

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pauta")
    private List<VotoEntity> votos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pauta")
    private SessaoVotoEntity sessao;

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

    public List<VotoEntity> getVotos() {
        return votos;
    }

    public void setVotos(List<VotoEntity> votos) {
        this.votos = votos;
    }

    public SessaoVotoEntity getSessao() {
        return sessao;
    }

    public void setSessao(SessaoVotoEntity sessao) {
        this.sessao = sessao;
    }
}
