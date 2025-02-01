package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.domain.associado.AssociadoDTO;
import br.com.dbserver.votacao.domain.pauta.PautaDTO;
import br.com.dbserver.votacao.domain.sessaoVoto.SessaoVotoDTO;
import br.com.dbserver.votacao.domain.voto.EnTipoVoto;
import br.com.dbserver.votacao.domain.voto.VotoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VotoServiceTest {

    @Autowired
    private PautaService pautaService;

    @Autowired
    private SessaoVotoService sessaoVotoService;

    @Autowired
    private VotoService votoService;

    @Autowired
    private AssociadoService associadoService;

    //Teste focado em criar um voto a partir de uma sessao e pauta;
    @Test
    public void testCriarVoto() {

        AssociadoDTO associadoDTO = new AssociadoDTO();
        String variacao = String.valueOf(Math.random()).substring(2);
        associadoDTO.setNome("Fulano " + variacao);
        associadoDTO.setEmail(String.format("%s@email.com", variacao));
        associadoDTO = associadoService.save(associadoDTO);
        assertNotNull(associadoDTO.getId());

        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setTitulo("Título da pauta " + variacao);
        pautaDTO.setDescricao(String.format("Descrição da pauta %s", variacao));
        pautaDTO = pautaService.save(pautaDTO);

        assertNotNull(pautaDTO.getId());

        SessaoVotoDTO sessaoVotoDTO = new SessaoVotoDTO();
        sessaoVotoDTO.setIdPauta(pautaDTO.getId());
        sessaoVotoDTO = sessaoVotoService.save(sessaoVotoDTO);
        assertNotNull(sessaoVotoDTO.getId());

        VotoDTO votoDTO = new VotoDTO();
        votoDTO.setIdPauta(pautaDTO.getId());
        votoDTO.setIdAssociado(associadoDTO.getId());
        votoDTO.setTipoVoto(EnTipoVoto.SIM);
        //veirifico se a sessaão inda está ativapara prosseguir para a etapa de salvamento do voto
        assertEquals(true, sessaoVotoDTO.isSessaoAberta());
        votoDTO = votoService.save(votoDTO);
        assertNotNull(votoDTO.getId());

    }
}
