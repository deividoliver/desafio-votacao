package br.com.dbserver.votacao.domain.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ISystemRepository<E extends SystemAbstractEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {

    List<E> findAllByAtivo(boolean ativo);
}
