package br.com.curso.core.exception;

public class InternalServerError extends  Exception{
    private String code;

    public InternalServerError(String message, String code ) {
        super(message);
        this.code = code;
    }
}
