package br.com.dbserver.votacao.domain.associado;

import br.com.dbserver.votacao.domain.generic.SystemAbstractDTO;

public class AssociadoDTO extends SystemAbstractDTO {

    private String nome;
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
