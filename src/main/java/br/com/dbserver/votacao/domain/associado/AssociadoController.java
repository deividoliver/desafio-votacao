package br.com.dbserver.votacao.domain.associado;

import br.com.dbserver.votacao.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssociadoDTO>> findAll() {

        return new ResponseEntity<>(associadoService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssociadoDTO> create(@RequestBody AssociadoDTO dto) {
        dto = this.associadoService.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
