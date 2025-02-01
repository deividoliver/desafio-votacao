package br.com.dbserver.votacao.exception;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException() {
        super("Registro não encontrado");
    }

    public NaoEncontradoException(String message) {
        super(message);
    }

    public NaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NaoEncontradoException(Throwable cause) {
        super(cause);
    }

    public NaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}