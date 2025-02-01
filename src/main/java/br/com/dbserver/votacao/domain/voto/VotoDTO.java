package br.com.dbserver.votacao.domain.voto;

import br.com.dbserver.votacao.domain.associado.AssociadoDTO;
import br.com.dbserver.votacao.domain.generic.GenericDTO;
import br.com.dbserver.votacao.domain.pauta.PautaDTO;

public class VotoDTO extends GenericDTO {

    private PautaDTO pautaDTO;

    private AssociadoDTO associadoDTO;

    private EnTipoVoto tipoVoto;

    public PautaDTO getPautaDTO() {
        return pautaDTO;
    }

    public void setPautaDTO(PautaDTO pautaDTO) {
        this.pautaDTO = pautaDTO;
    }

    public AssociadoDTO getAssociadoDTO() {
        return associadoDTO;
    }

    public void setAssociadoDTO(AssociadoDTO associadoDTO) {
        this.associadoDTO = associadoDTO;
    }

    public EnTipoVoto getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(EnTipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }
}
