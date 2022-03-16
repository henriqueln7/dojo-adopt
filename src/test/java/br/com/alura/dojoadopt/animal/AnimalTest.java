package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.owner.Owner;
import org.junit.jupiter.api.*;

import static br.com.alura.dojoadopt.animal.AnimalBuilder.anAnimal;
import static br.com.alura.dojoadopt.owner.OwnerBuilder.anOwner;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AnimalTest {

    @Nested
    class BeAdoptedBy {
        @Test
        @DisplayName("should reject if animal already has owner")
        void should_reject_if_animal_already_has_owner() {
            Owner owner = anOwner().build();
            Owner anotherOwner = anOwner().build();
            Animal animal = anAnimal().build();

            animal.beAdoptedBy(owner);

            assertThatIllegalArgumentException().isThrownBy(() -> animal.beAdoptedBy(anotherOwner));
        }
    }
}