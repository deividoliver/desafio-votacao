package br.com.dbserver.votacao.converter;

import br.com.dbserver.votacao.exception.NaoEncontradoException;
import br.com.dbserver.votacao.exception.VotacaoException;
import br.com.dbserver.votacao.utils.Util;
import br.com.dbserver.votacao.domain.generic.GenericConverter;
import br.com.dbserver.votacao.domain.pauta.PautaEntity;
import br.com.dbserver.votacao.domain.sessaoVoto.SessaoVotoDTO;
import br.com.dbserver.votacao.domain.sessaoVoto.SessaoVotoEntity;
import br.com.dbserver.votacao.repository.IPautaRepository;
import br.com.dbserver.votacao.repository.ISessaoVotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Component
public class SessaoVotoConveter extends GenericConverter<SessaoVotoEntity, SessaoVotoDTO, ISessaoVotoRepository> {

    @Autowired
    private ISessaoVotoRepository repository;

    @Autowired
    private IPautaRepository pautaRepository;

    public SessaoVotoEntity toEntity(SessaoVotoDTO dto) {
        try {
            if (dto == null) return null;

            SessaoVotoEntity entity = new SessaoVotoEntity();

            if (!Util.isNew(dto)) {
                Optional<SessaoVotoEntity> entityOptional = repository.findById(dto.getId());
                if (entityOptional.isPresent()) {
                    entity = entityOptional.get();
                }
            } else {
                Optional<PautaEntity> pautaEntity = pautaRepository.findById(dto.getIdPauta());
                if (!pautaEntity.isPresent()) {
                    throw new NaoEncontradoException("Pauta não encontrada");
                }
                entity.setPauta(pautaEntity.get());
                //convertendo a data timestamp do front para localdatetime
                if (Util.isNotNull(dto.getDataFechamento())) {
                    entity.setDataFechamento(LocalDateTime.ofInstant(Instant.ofEpochSecond(dto.getDataFechamento()), ZoneId.systemDefault()));
                }
            }

            entity = entity(entity, dto);

            return entity;
        } catch (Exception e) {
            throw new VotacaoException(e.getMessage());
        }
    }

    public SessaoVotoDTO toDto(SessaoVotoEntity entity) {
        try {
            SessaoVotoDTO dto = new SessaoVotoDTO();
            dto(entity, dto);
            dto.setDataAbertura(entity.getDataAbertura().atZone(ZoneId.systemDefault()).toEpochSecond());
            dto.setDataFechamento(entity.getDataFechamento().atZone(ZoneId.systemDefault()).toEpochSecond());
            dto.setIdPauta(entity.getPauta().getId());

            return dto;
        } catch (Exception e) {
            throw new VotacaoException(e.getMessage());
        }
    }
}
