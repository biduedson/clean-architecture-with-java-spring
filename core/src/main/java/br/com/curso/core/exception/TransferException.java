package br.com.curso.core.exception;

public class TransferException extends Throwable {
private  String code;

    public TransferException(String message, String code) {
        super(message);
        this.code = code;
    }
}
