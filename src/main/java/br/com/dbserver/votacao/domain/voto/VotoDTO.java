package br.com.dbserver.votacao.domain.voto;

import br.com.dbserver.votacao.domain.generic.GenericDTO;

public class VotoDTO extends GenericDTO {

    private Long idPauta;

    private Long idAssociado;

    private EnTipoVoto tipoVoto;

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public Long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(Long idAssociado) {
        this.idAssociado = idAssociado;
    }

    public EnTipoVoto getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(EnTipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }
}
