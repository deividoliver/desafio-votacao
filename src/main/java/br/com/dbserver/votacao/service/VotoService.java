package br.com.dbserver.votacao.service;

import br.com.dbserver.votacao.utils.Util;
import br.com.dbserver.votacao.converter.VotoConverter;
import br.com.dbserver.votacao.domain.voto.VotoDTO;
import br.com.dbserver.votacao.domain.voto.VotoEntity;
import br.com.dbserver.votacao.exception.VotacaoException;
import br.com.dbserver.votacao.repository.IVotoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VotoService {

    @Autowired
    private VotoConverter converter;

    @Autowired
    private IVotoRepository repository;

    public List<VotoDTO> findAll() {
        return repository.findAll().stream().map(a -> converter.toDto(a)).toList();
    }

    @Transactional
    public VotoDTO save(VotoDTO dto) {

        VotoEntity entity = converter.toEntity(dto);
        if(!entity.getPautaEntity().getSessaoVoto().isSessaoAberta()){
            throw new VotacaoException("Sessão de voto fechada");
        }

        VotoEntity votoRealizdo = repository.findVotoByPautaAndAssociado(dto.getIdPauta(), dto.getIdAssociado());

        if(Util.isNotNull(votoRealizdo)){
            throw new VotacaoException("Voto já realizado.");
        }

        entity = repository.save(entity);
        return converter.toDto(entity);
    }
}
