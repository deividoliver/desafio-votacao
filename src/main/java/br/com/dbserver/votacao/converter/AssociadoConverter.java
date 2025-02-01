package br.com.dbserver.votacao.converter;

import br.com.dbserver.votacao.Util;
import br.com.dbserver.votacao.domain.associado.AssociadoDTO;
import br.com.dbserver.votacao.domain.associado.AssociadoEntity;
import br.com.dbserver.votacao.domain.generic.SystemConverter;
import br.com.dbserver.votacao.exception.NaoEncontradoException;
import br.com.dbserver.votacao.repository.IAssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AssociadoConverter extends SystemConverter<AssociadoEntity, AssociadoDTO, IAssociadoRepository> {

    @Autowired
    private IAssociadoRepository repository;

    public AssociadoEntity toEntity(AssociadoDTO dto) {
        try {
            if (dto == null) return null;

            AssociadoEntity entity = new AssociadoEntity();

            if (!Util.isNew(dto)) {
                Optional<AssociadoEntity> entityOptional = repository.findById(dto.getId());
                if (entityOptional.isPresent()) {
                    entity = entityOptional.get();
                }
            }

            entity = this.entity(entity, dto);
            entity.setNome(dto.getNome());
            entity.setEmail(dto.getEmail());

            return entity;
        } catch (Exception e) {
            throw new NaoEncontradoException();
        }
    }

    public AssociadoDTO toDto(AssociadoEntity entity) {
        try {
            AssociadoDTO dto = new AssociadoDTO();
            this.dto(entity, dto);
            dto.setNome(entity.getNome());
            dto.setEmail(entity.getEmail());
            return dto;
        } catch (Exception e) {
            return null;
        }
    }


}
