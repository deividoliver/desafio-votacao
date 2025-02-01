package br.com.dbserver.votacao.domain.sessaoVoto;

import br.com.dbserver.votacao.domain.generic.GenericDTO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class SessaoVotoDTO extends GenericDTO {

    private Long dataAbertura = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();

    private Long dataFechamento;

    private Long idPauta;

    public Long getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Long dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Long getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Long dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public boolean isSessaoAberta() {
        return LocalDateTime.now().isBefore(LocalDateTime.ofInstant(Instant.ofEpochSecond(dataFechamento), ZoneId.systemDefault()));
    }
}
