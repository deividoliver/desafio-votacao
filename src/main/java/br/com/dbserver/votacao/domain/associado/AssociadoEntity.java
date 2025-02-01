package br.com.dbserver.votacao.domain.associado;

import br.com.dbserver.votacao.domain.generic.SystemAbstractEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "associado")
@AttributeOverride(name = "id", column = @Column(name = "id_associado"))
@SequenceGenerator(name = "SQ_GENERATOR", sequenceName = "sequence_associado", allocationSize = 1)
public class AssociadoEntity extends SystemAbstractEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}