package br.com.alura.dojoadopt.owner;

import java.math.BigDecimal;

public record OwnerProfileView(String name, String cpf, BigDecimal remuneration, BigDecimal monthlyExpenses, String photoUrl) {
    public OwnerProfileView(Owner owner) {
        this(owner.getName(), owner.getCpf(), owner.getRemuneration(), owner.getMonthlyExpenses(), owner.getPhotoUrl());
    }
}
