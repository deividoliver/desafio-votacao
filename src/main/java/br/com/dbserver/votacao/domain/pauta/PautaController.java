package br.com.dbserver.votacao.domain.pauta;

import br.com.dbserver.votacao.service.PautaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    private static final Logger log = LoggerFactory.getLogger(PautaController.class);
    @Autowired
    private PautaService pautaService;

    @ResponseBody
    @GetMapping(value = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PautaDTO> find(@PathVariable("id") Long id) {
        PautaDTO dto = pautaService.find(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PautaDTO>> findAll() {
        return new ResponseEntity<>(pautaService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PautaDTO> create(@RequestBody PautaDTO dto) {
        dto = pautaService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
