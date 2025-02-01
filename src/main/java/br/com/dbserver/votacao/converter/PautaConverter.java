package br.com.dbserver.votacao.converter;

import br.com.dbserver.votacao.Util;
import br.com.dbserver.votacao.domain.generic.GenericConverter;
import br.com.dbserver.votacao.domain.pauta.PautaDTO;
import br.com.dbserver.votacao.domain.pauta.PautaEntity;
import br.com.dbserver.votacao.exception.NaoEncontradoException;
import br.com.dbserver.votacao.repository.IPautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PautaConverter extends GenericConverter<PautaEntity, PautaDTO, IPautaRepository> {

    @Autowired
    private IPautaRepository repository;

    public PautaEntity toEntity(PautaDTO dto) {
        try {
            if (dto == null) return null;

            PautaEntity entity = new PautaEntity();

            if (!Util.isNew(dto)) {
                Optional<PautaEntity> entityOptional = repository.findById(dto.getId());
                if (entityOptional.isPresent()) {
                    entity = entityOptional.get();
                }
            }

            entity = this.entity(entity, dto);
            entity.setTitulo(dto.getTitulo());
            entity.setDescricao(dto.getDescricao());

            return entity;
        } catch (Exception e) {
            throw new NaoEncontradoException();
        }
    }

    public PautaDTO toDto(PautaEntity entity) {
        try {
            PautaDTO dto = new PautaDTO();
            this.dto(entity, dto);
            dto.setTitulo(entity.getTitulo());
            dto.setDescricao(entity.getDescricao());
            return dto;
        } catch (Exception e) {
            throw new NaoEncontradoException();
        }
    }

}

