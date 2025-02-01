package br.com.dbserver.votacao.domain.generic;

import br.com.dbserver.votacao.Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class SystemConverter <
        E extends SystemAbstractEntity,
        D extends SystemAbstractDTO,
        R extends ISystemRepository> {

    @Autowired
    private R repository;

    public D dto(E entity, D dto) {
        dto.setId(entity.getId());
        dto.setAtivo(entity.isAtivo());
        if(Util.isNotNull(entity.getDataAlteracao())){
            dto.setDataAlteracao(entity.getDataAlteracao().atZone(ZoneId.systemDefault()).toEpochSecond());
        }
        if(Util.isNotNull(entity.getDataCadastro())){
            dto.setDataCadastro(entity.getDataCadastro().atZone(ZoneId.systemDefault()).toEpochSecond());
        }

        return dto;
    }

    public E entity(E entity, D dto) {
        entity.setId(dto.getId());
        entity.setAtivo(dto.isAtivo());
        entity.setDataAlteracao(LocalDateTime.now());
        if (entity.isNew()) {
            entity.setDataCadastro(LocalDateTime.now());
        }

        return entity;
    }
}
