package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.owner.Owner;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.animal.AnimalSize.BIG;
import static br.com.alura.dojoadopt.animal.AnimalSize.GIANT;
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
            return owner.livesIn(FARM) || (!owner.hasCats() && !owner.hasDogs());

        }
    },
    DOG("Cachorro") {
        @Override
        public boolean accepts(Owner owner) {
            return !owner.livesIn(APARTMENT) || !owner.hasDogWithSize(BIG, GIANT);
        }
    },
    CAT("Gato") {
        @Override
        public boolean accepts(Owner owner) {
            return !owner.hasMoreThanNDogs(3);
        }
    },
    BIRD("Pássarasalto") {
        @Override
        public boolean accepts(Owner owner) {
            return !StringUtils.startsWithIgnoreCase(owner.getName(), "A") && !owner.isUnderAge() && !owner.livesIn(APARTMENT);
        }
    },
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

    public abstract boolean accepts(Owner owner);
}
