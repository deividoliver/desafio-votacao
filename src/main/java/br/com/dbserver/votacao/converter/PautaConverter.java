package br.com.dbserver.votacao.converter;

import br.com.dbserver.votacao.domain.generic.GenericConverter;
import br.com.dbserver.votacao.domain.pauta.PautaDTO;
import br.com.dbserver.votacao.domain.pauta.PautaEntity;
import br.com.dbserver.votacao.domain.voto.EnTipoVoto;
import br.com.dbserver.votacao.exception.VotacaoException;
import br.com.dbserver.votacao.repository.IPautaRepository;
import br.com.dbserver.votacao.utils.Util;
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

            entity = entity(entity, dto);
            entity.setTitulo(dto.getTitulo());
            entity.setDescricao(dto.getDescricao());

            return entity;
        } catch (Exception e) {
            throw new VotacaoException(e.getMessage());
        }
    }

    public PautaDTO toDto(PautaEntity entity) {
        try {
            PautaDTO dto = new PautaDTO();
            dto(entity, dto);
            dto.setTitulo(entity.getTitulo());
            dto.setDescricao(entity.getDescricao());

            //Realizando a contagem de votos referente à pauta
            if (Util.isNotNull(entity.getVotos())) {
                dto.setTotalVotos(entity.getVotos().size());
                dto.setTotalVotosSim(0);
                dto.setTotalVotosNao(0);
                for (int i = 0; i < entity.getVotos().size(); i++) {
                    if (entity.getVotos().get(i).getTipoVoto().equals(EnTipoVoto.SIM)) {
                        dto.setTotalVotosSim(dto.getTotalVotosSim() + 1);
                    } else {
                        dto.setTotalVotosNao(dto.getTotalVotosNao() + 1);
                    }
                }
            }

            return dto;
        } catch (Exception e) {
            throw new VotacaoException(e.getMessage());
        }
    }

}

