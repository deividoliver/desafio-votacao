package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.converter.AssociadoConverter;
import br.com.dbserver.votacao.converter.PautaConverter;
import br.com.dbserver.votacao.domain.associado.AssociadoDTO;
import br.com.dbserver.votacao.domain.associado.AssociadoEntity;
import br.com.dbserver.votacao.domain.pauta.PautaDTO;
import br.com.dbserver.votacao.domain.pauta.PautaEntity;
import br.com.dbserver.votacao.repository.IAssociadoRepository;
import br.com.dbserver.votacao.repository.IPautaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PautaService {

    @Autowired
    private PautaConverter converter;

    @Autowired
    private IPautaRepository repository;

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
