package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.domain.pauta.PautaDTO;
import br.com.dbserver.votacao.domain.sessaoVoto.SessaoVotoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SessaoVotoServiceTest {

    @Autowired
    private PautaService pautaService;

    @Autowired
    private SessaoVotoService sessaoVotoService;


    //Teste focado em criar uma sessao de voto a partir de uma pauta criada;
    @Test
    public void testCriarSessaoVoto(){
        PautaDTO pautaDTO = new PautaDTO();
        String variacao = String.valueOf(Math.random()).substring(2);
        pautaDTO.setTitulo("Título da pauta " + variacao);
        pautaDTO.setDescricao(String.format("Descrição da pauta %s", variacao));
        pautaDTO = pautaService.save(pautaDTO);

        assertNotNull(pautaDTO.getId());

        SessaoVotoDTO sessaoVotoDTO = new SessaoVotoDTO();
        sessaoVotoDTO.setIdPauta(pautaDTO.getId());
        sessaoVotoDTO = sessaoVotoService.save(sessaoVotoDTO);
        assertNotNull(sessaoVotoDTO.getId());

    }
}
