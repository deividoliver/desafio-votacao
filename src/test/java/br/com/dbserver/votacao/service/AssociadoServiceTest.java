package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.domain.associado.AssociadoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AssociadoServiceTest {

    @Autowired
    private AssociadoService associadoService;

    //Teste focado em criar um cadastro do associado.
    @Test
    public void testCriarAssociado() {
        AssociadoDTO associadoDTO = new AssociadoDTO();
        String variacao = String.valueOf(Math.random()).substring(2);
        associadoDTO.setNome("Fulano " + variacao);
        associadoDTO.setEmail(String.format("%s@email.com", variacao));
        associadoDTO = associadoService.save(associadoDTO);
        assertNotNull(associadoDTO.getId());

    }
}
