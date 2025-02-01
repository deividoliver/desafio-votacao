package br.com.dbserver.votacao.converter;

import br.com.dbserver.votacao.exception.VotacaoException;
import br.com.dbserver.votacao.utils.Util;
import br.com.dbserver.votacao.domain.associado.AssociadoEntity;
import br.com.dbserver.votacao.domain.generic.GenericConverter;
import br.com.dbserver.votacao.domain.pauta.PautaEntity;
import br.com.dbserver.votacao.domain.voto.VotoDTO;
import br.com.dbserver.votacao.domain.voto.VotoEntity;
import br.com.dbserver.votacao.exception.NaoEncontradoException;
import br.com.dbserver.votacao.repository.IAssociadoRepository;
import br.com.dbserver.votacao.repository.IPautaRepository;
import br.com.dbserver.votacao.repository.IVotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VotoConverter extends GenericConverter<VotoEntity, VotoDTO, IVotoRepository> {


    @Autowired
    private IVotoRepository repository;

    @Autowired
    private IPautaRepository pautaRepository;

    @Autowired
    private IAssociadoRepository associadoRepository;

    public VotoEntity toEntity(VotoDTO dto) {
        try {
            if (dto == null) return null;

            VotoEntity entity = new VotoEntity();

            if (!Util.isNew(dto)) {
                Optional<VotoEntity> entityOptional = repository.findById(dto.getId());
                if (entityOptional.isPresent()) {
                    entity = entityOptional.get();
                }
            } else {
                Optional<PautaEntity> pautaEntity = pautaRepository.findById(dto.getIdPauta());
                if (!pautaEntity.isPresent()) {
                    throw new NaoEncontradoException("Pauta não encontrada");
                }
                entity.setPautaEntity(pautaEntity.get());

                Optional<AssociadoEntity> associadoEntity = associadoRepository.findById(dto.getIdAssociado());
                if (!associadoEntity.isPresent()) {
                    throw new NaoEncontradoException("Associado não encontrada");
                }
                entity.setAssociadoEntity(associadoEntity.get());

            }

            entity = entity(entity, dto);
            entity.setTipoVoto(dto.getTipoVoto());

            return entity;
        } catch (Exception e) {
            throw new VotacaoException(e.getMessage());
        }
    }

    public VotoDTO toDto(VotoEntity entity) {
        try {
            VotoDTO dto = new VotoDTO();
            dto(entity, dto);
            dto.setTipoVoto(entity.getTipoVoto());
            dto.setIdAssociado(entity.getAssociadoEntity().getId());
            dto.setIdPauta(entity.getPautaEntity().getId());
            return dto;
        } catch (Exception e) {
            throw new VotacaoException(e.getMessage());
        }
    }
}