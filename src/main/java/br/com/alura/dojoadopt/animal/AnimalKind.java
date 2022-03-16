package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.owner.HomeKind;
import br.com.alura.dojoadopt.owner.Owner;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.owner.HomeKind.*;

public enum AnimalKind {
    FISH("Peixe"),
    REPTILE("Réptil"),
    DOG("Cachorro"),
    CAT("Gato"),
    BIRD("Pássarasalto"),
    EXOTIC("Exótico") {
        @Override
        public boolean accepts(Owner owner) {
            return owner.hasRemunerationOver(new BigDecimal("50000")) && owner.livesIn(FARM);
        }
    };

    private String displayName;

    AnimalKind(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean accepts(Owner owner) {
        return true;
    }
}
