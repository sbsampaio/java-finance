package br.ufes.inf.labes.finance.core.domain;

import br.ufes.inf.labes.jbutler.ejb.persistence.PersistentObjectSupport;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Account extends PersistentObjectSupport {
    @Size(max = 100)
    private String name;

    @NotNull
    private String type;

    @NotNull
    private float balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return name;
    }
}
