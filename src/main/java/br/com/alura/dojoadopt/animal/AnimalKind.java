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
                return !owner.hasDogWithSize(BIG, GIANT);
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
    BIRD("Pássarasalto") {
        @Override
        public boolean accepts(Owner owner) {
//            o nome da pessoa não pode começar com a letra "A", a pessoa precisa ter mais de 18 anos e não pode morar em apartamento.
            if (StringUtils.startsWithIgnoreCase(owner.getName(), "A")) {
                return false;
            }
            if (owner.isUnderAge()) {
                return false;
            }
            if (owner.livesIn(APARTMENT)) {
                return false;
            }
            return true;
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

    public boolean accepts(Owner owner) {
        return true;
    }
}
