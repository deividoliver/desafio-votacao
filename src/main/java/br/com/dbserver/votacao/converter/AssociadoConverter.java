package br.com.dbserver.votacao.converter;

import br.com.dbserver.votacao.domain.associado.AssociadoDTO;
import br.com.dbserver.votacao.domain.associado.AssociadoEntity;
import br.com.dbserver.votacao.domain.generic.GenericConverter;
import br.com.dbserver.votacao.exception.VotacaoException;
import br.com.dbserver.votacao.repository.IAssociadoRepository;
import br.com.dbserver.votacao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AssociadoConverter extends GenericConverter<AssociadoEntity, AssociadoDTO, IAssociadoRepository> {

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

            entity = entity(entity, dto);
            entity.setNome(dto.getNome());
            entity.setEmail(dto.getEmail());

            return entity;
        } catch (Exception e) {
            throw new VotacaoException(e.getMessage());
        }
    }

    public AssociadoDTO toDto(AssociadoEntity entity) {
        try {
            AssociadoDTO dto = new AssociadoDTO();
            dto(entity, dto);
            dto.setNome(entity.getNome());
            dto.setEmail(entity.getEmail());
            return dto;
        } catch (Exception e) {
            throw new VotacaoException(e.getMessage());
        }
    }

}
