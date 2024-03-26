package br.com.curso.core.exception.enuns;

public enum ErrorCodeEnum {
    ON0001("Tax Number invalido.", "ON-0001"),
    ON0002("Tax Number indisponivel.", "ON-0002"),
    ON0003("E-mail indisponivel indisponivel.", "ON-0003"),
    ON0004("Houve um erro na criação do usuario.", "ON-0004"),

    TR0001("Usuário lojista não tem a função transferência disponiovel.", "TR-0001"),
    TR0002("Saldo indisponivel", "TR-0002"),
    TRP0001("Pin invalido","TRP-0001"),

    TR0003("Houve um erro ao fazer a transferencia.", "TR-0003"),

    WA0001("Carteira não encontrada.", "WA-0001"),
    NO0001("Houve  um erro na notificação do usuário.", "NO-0001"),
    TR0004("Transferencia não autorizada.", "TR-0004"),
    ATH0001("Houve  um erro na autenticação.", "AT-0001")
    ;


    private String message;
    private  String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
