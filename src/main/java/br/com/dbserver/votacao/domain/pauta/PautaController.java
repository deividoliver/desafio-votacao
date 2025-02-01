package br.com.dbserver.votacao.domain.pauta;

import br.com.dbserver.votacao.domain.associado.AssociadoDTO;
import br.com.dbserver.votacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PautaDTO>> findAll() {
        return new ResponseEntity<>(pautaService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PautaDTO> create(@RequestBody PautaDTO dto) {
        dto = this.pautaService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
