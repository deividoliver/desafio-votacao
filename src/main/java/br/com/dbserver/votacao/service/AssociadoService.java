package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.converter.AssociadoConverter;
import br.com.dbserver.votacao.domain.associado.AssociadoDTO;
import br.com.dbserver.votacao.domain.associado.AssociadoEntity;
import br.com.dbserver.votacao.repository.IAssociadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AssociadoService {

    @Autowired
    private AssociadoConverter converter;

    @Autowired
    private IAssociadoRepository repository;

    public List<AssociadoDTO> findAll(){
        return repository.findAll().stream().map(a->converter.toDto(a)).toList();
    }

    @Transactional
    public AssociadoDTO save(AssociadoDTO dto) {
        AssociadoEntity entity = converter.toEntity(dto);
        entity = repository.save(entity);
        return converter.toDto(entity);
    }
}
