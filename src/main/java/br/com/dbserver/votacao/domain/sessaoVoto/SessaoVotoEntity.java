package br.com.dbserver.votacao.domain.sessaoVoto;

import br.com.dbserver.votacao.domain.generic.GenericEntity;
import br.com.dbserver.votacao.domain.pauta.PautaEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessao")
@AttributeOverride(name = "id", column = @Column(name = "id_sessao"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "sequence_sessao", allocationSize = 1)
public class SessaoVotoEntity extends GenericEntity {

    @Column(name = "data_abertura", nullable = false, updatable = false)
    private LocalDateTime dataAbertura = LocalDateTime.now();

    @Column(name = "data_fechamento", nullable = false, updatable = false)
    private LocalDateTime dataFechamento = LocalDateTime.now().plusMinutes(1);

    @OneToOne
    @JoinColumn(name = "id_pauta", nullable = false, unique = true)
    private PautaEntity pautaEntity;

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public PautaEntity getPautaEntity() {
        return pautaEntity;
    }

    public void setPautaEntity(PautaEntity pautaEntity) {
        this.pautaEntity = pautaEntity;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public boolean isSessaoAberta() {
        return LocalDateTime.now().isBefore(dataFechamento);
    }
}
