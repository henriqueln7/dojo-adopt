package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.owner.Owner;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.owner.HomeKind.*;

public enum AnimalKind {
    FISH("Peixe") {
        @Override
        public boolean accepts(Owner owner) {
            return owner.livesIn(HOUSE_WITH_POOL);
        }
    },
    REPTILE("Réptil") {
        @Override
        public boolean accepts(Owner owner) {
            if (owner.livesIn(FARM)) {
                return true;
            }

            return !owner.hasCats() && !owner.hasDogs();
        }
    },
    DOG("Cachorro") {
        @Override
        public boolean accepts(Owner owner) {
            if (owner.livesIn(APARTMENT)) {
                // caso a pessoa more em apartamento, só podemos ter apenas 1 cachorro (GRANDE ou GIGANTE)
            }
            return true;
        }
    },
    CAT("Gato") {
        @Override
        public boolean accepts(Owner owner) {
            return !owner.hasMoreThanNDogs(3);
        }
    },
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
