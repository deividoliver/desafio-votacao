package br.com.dbserver.votacao.domain.voto;

import br.com.dbserver.votacao.service.VotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voto")
public class VotoController {

    private static final Logger log = LoggerFactory.getLogger(VotoController.class);
    @Autowired
    private VotoService votoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VotoDTO>> findAll() {
        return new ResponseEntity<>(votoService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VotoDTO> create(@RequestBody VotoDTO dto) {
        dto = votoService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
