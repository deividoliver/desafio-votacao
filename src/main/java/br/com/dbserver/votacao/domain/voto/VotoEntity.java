package br.com.dbserver.votacao.domain.voto;

import br.com.dbserver.votacao.domain.associado.AssociadoEntity;
import br.com.dbserver.votacao.domain.generic.GenericEntity;
import br.com.dbserver.votacao.domain.pauta.PautaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "voto")
@AttributeOverride(name = "id", column = @Column(name = "id_voto"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "sequence_voto", allocationSize = 1)
public class VotoEntity extends GenericEntity {

    @ManyToOne
    @JoinColumn(name = "id_pauta", nullable = false)
    private PautaEntity pautaEntity;

    @ManyToOne
    @JoinColumn(name = "id_associado", nullable = false)
    private AssociadoEntity associadoEntity;  // Como criamos a entidade de associado podemos relacionar na tabela

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_voto",nullable = false)
    private EnTipoVoto tipoVoto;

    public PautaEntity getPautaEntity() {
        return pautaEntity;
    }

    public void setPautaEntity(PautaEntity pautaEntity) {
        this.pautaEntity = pautaEntity;
    }

    public AssociadoEntity getAssociadoEntity() {
        return associadoEntity;
    }

    public void setAssociadoEntity(AssociadoEntity associadoEntity) {
        this.associadoEntity = associadoEntity;
    }

    public EnTipoVoto getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(EnTipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }
}
