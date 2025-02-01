package br.com.dbserver.votacao.exception;

import java.util.LinkedHashMap;
import java.util.Map;

public class VotacaoException extends RuntimeException {
    private String mensagem;
    private Map<String, Object> validations = new LinkedHashMap<>();

    public VotacaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public VotacaoException(String mensagem, Map<String, Object> validations) {
        this.mensagem = mensagem;
        this.validations = validations;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Map<String, Object> getValidations() {
        return validations;
    }
}
