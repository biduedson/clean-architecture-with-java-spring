package br.com.curso.core.domain;

import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.core.exception.enuns.ErrorCodeEnum;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TransactionPin {
    private Long id;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public TransactionPin(Long id,String pin, Integer attempt, Boolean blocked, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createAt;
        this.updatedAt = updateAt;
    }

    public TransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public TransactionPin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }

    private  boolean pinIsValid(String pin) throws TransactionPinException {
        if(pin.length() !=8){
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }
        return  true;
    }
    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt() {
        if(this.attempt == 1){
           this.blocked = true;
           this.attempt = 0;
        }else{
            this.attempt = this.attempt - 1;
        }

    }

    public void restoreAttempt(){
        this.attempt = 3;
    }


    public  Boolean getBlocked(){return  blocked;}
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionPin that)) return false;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getPin().equals(that.getPin())) return false;
        if (!getAttempt().equals(that.getAttempt())) return false;
        if (!getBlocked().equals(that.getBlocked())) return false;
        if (!getCreatedAt().equals(that.getCreatedAt())) return false;
        return getUpdatedAt() != null ? getUpdatedAt().equals(that.getUpdatedAt()) : that.getUpdatedAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getPin().hashCode();
        result = 31 * result + getAttempt().hashCode();
        result = 31 * result + getBlocked().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        return result;
    }
}
