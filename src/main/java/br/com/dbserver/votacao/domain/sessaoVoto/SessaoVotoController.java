package br.com.dbserver.votacao.domain.sessaoVoto;

import br.com.dbserver.votacao.service.SessaoVotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessao-voto")
public class SessaoVotoController {

    private static final Logger log = LoggerFactory.getLogger(SessaoVotoController.class);
    @Autowired
    private SessaoVotoService sessaoVotoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SessaoVotoDTO>> findAll() {
        return new ResponseEntity<>(sessaoVotoService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessaoVotoDTO> create(@RequestBody SessaoVotoDTO dto) {
        dto = sessaoVotoService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
