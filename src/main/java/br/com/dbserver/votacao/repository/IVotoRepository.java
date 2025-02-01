package br.com.dbserver.votacao.repository;

import br.com.dbserver.votacao.domain.generic.IGenericRepository;
import br.com.dbserver.votacao.domain.voto.VotoEntity;
import org.springframework.data.jpa.repository.Query;

public interface IVotoRepository extends IGenericRepository<VotoEntity> {

    @Query(value = "SELECT v.* FROM voto v " +
            "JOIN pauta p ON p.id_pauta=v.id_pauta " +
            "JOIN associado o ON o.id_associado=v.id_associado " +
            "WHERE v.id_pauta = ?1 AND v.id_associado = ?2 limit 1", nativeQuery = true)
    VotoEntity findVotoByPautaAndAssociado(Long idPauta, Long idAssociado);
}
