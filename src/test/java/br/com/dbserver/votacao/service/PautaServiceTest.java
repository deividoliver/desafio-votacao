package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.domain.pauta.PautaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PautaServiceTest {

    @Autowired
    private PautaService pautaService;

    //Teste focado em criar uma pauta
    @Test
    public void testCriarPauta(){
        PautaDTO dto = new PautaDTO();
        String variacao = String.valueOf(Math.random()).substring(2);
        dto.setTitulo("Título da pauta " + variacao);
        dto.setDescricao(String.format("Descrição da pauta %s", variacao));
        dto = pautaService.save(dto);
        assertNotNull(dto.getId());
    }
}
