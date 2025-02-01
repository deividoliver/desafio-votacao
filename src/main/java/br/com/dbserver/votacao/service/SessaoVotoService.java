package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.converter.SessaoVotoConveter;
import br.com.dbserver.votacao.domain.sessaoVoto.SessaoVotoDTO;
import br.com.dbserver.votacao.domain.sessaoVoto.SessaoVotoEntity;
import br.com.dbserver.votacao.exception.VotacaoException;
import br.com.dbserver.votacao.repository.ISessaoVotoRepository;
import br.com.dbserver.votacao.utils.Util;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SessaoVotoService {

    @Autowired
    private SessaoVotoConveter converter;

    @Autowired
    private ISessaoVotoRepository repository;

    public List<SessaoVotoDTO> findAll() {
        return repository.findAll().stream().map(a -> converter.toDto(a)).toList();
    }

    @Transactional
    public SessaoVotoDTO save(SessaoVotoDTO dto) {
        SessaoVotoEntity entity = converter.toEntity(dto);
        if (!Util.isNew(entity.getPauta().getSessaoVoto())) {
            throw new VotacaoException("Seção de votação já cadastrada par esta pauta.");
        }
        entity = repository.save(entity);
        return converter.toDto(entity);
    }
}
