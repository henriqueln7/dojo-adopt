package br.com.alura.dojoadopt.animal;

import java.math.BigDecimal;

public interface MonthlyCostByKindProjection {
    AnimalKind getKind();

    Long getQuantity();

    BigDecimal getAverageMonthlyCost();

    default String getKindDisplayName() {
        return getKind().getDisplayName();
    }
}
