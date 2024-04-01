package br.com.curso.core.domain;

import br.com.curso.core.domain.enuns.UserTypeEnum;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;


public class User {
    private UUID id;
    private String emain;

    private String password;
    private  TaxNumber taxNumber;
    private  String  fullname;
   private UserTypeEnum type;
   private Timestamp createAt;
   private Timestamp updateAt;

    public User(String emain, String password, TaxNumber taxNumber, String fullname, UserTypeEnum type) {
        this.id = this.id;
        this.emain = emain;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullname = fullname;
        this.type = type;
        this.createAt = Timestamp.valueOf(LocalDateTime.now());
        this.updateAt = updateAt;
    }

    public User(String emain, String password, TaxNumber taxNumber, String fullname, UserTypeEnum type, TransactionPin transactionPin) {
        this.id = UUID.randomUUID();
        this.emain = emain;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullname = fullname;
        this.type = type;
        this.createAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmain() {
        return emain;
    }

    public void setEmain(String emain) {
        this.emain = emain;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxnumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }


    public Timestamp getCreateAt() {
        return createAt;
    }



    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Timestamp timeStampConvert(){
        LocalDateTime date = LocalDateTime.now();
        return Timestamp.valueOf(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!getId().equals(user.getId())) return false;
        if (!getEmain().equals(user.getEmain())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getTaxNumber().equals(user.getTaxNumber())) return false;
        if (!getFullname().equals(user.getFullname())) return false;
        if (getType() != user.getType()) return false;
        if (!getCreateAt().equals(user.getCreateAt())) return false;
        return getUpdateAt() != null ? getUpdateAt().equals(user.getUpdateAt()) : user.getUpdateAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmain().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getTaxNumber().hashCode();
        result = 31 * result + getFullname().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getCreateAt().hashCode();
        result = 31 * result + (getUpdateAt() != null ? getUpdateAt().hashCode() : 0);
        return result;
    }
}
