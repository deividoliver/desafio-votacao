package br.com.dbserver.votacao.domain.sessaoVoto;

import br.com.dbserver.votacao.domain.generic.GenericDTO;
import br.com.dbserver.votacao.domain.pauta.PautaDTO;

import java.time.LocalDateTime;

public class SessaoVotoDTO extends GenericDTO {

    private LocalDateTime dataAbertura = LocalDateTime.now();

    private LocalDateTime dataFechamento;

    private PautaDTO pautaDTO;

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public PautaDTO getPautaDTO() {
        return pautaDTO;
    }

    public void setPautaDTO(PautaDTO pautaDTO) {
        this.pautaDTO = pautaDTO;
    }
}
