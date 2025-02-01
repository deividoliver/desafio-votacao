package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.converter.PautaConverter;
import br.com.dbserver.votacao.domain.pauta.PautaDTO;
import br.com.dbserver.votacao.domain.pauta.PautaEntity;
import br.com.dbserver.votacao.exception.NaoEncontradoException;
import br.com.dbserver.votacao.repository.IPautaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PautaService {

    @Autowired
    private PautaConverter converter;

    @Autowired
    private IPautaRepository repository;

    public PautaDTO find(Long id) {
        Optional<PautaEntity> entity = repository.findById(id);
        if (!entity.isPresent()) throw new NaoEncontradoException();
        return converter.toDto(entity.get());
    }

    public List<PautaDTO> findAll(){
        return repository.findAll().stream().map(a->converter.toDto(a)).toList();
    }

    @Transactional
    public PautaDTO save(PautaDTO dto) {
        PautaEntity entity = converter.toEntity(dto);
        entity = repository.save(entity);
        return converter.toDto(entity);
    }
}
