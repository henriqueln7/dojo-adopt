package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.owner.Owner;
import org.junit.jupiter.api.*;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.animal.AnimalBuilder.anAnimal;
import static br.com.alura.dojoadopt.owner.OwnerBuilder.anOwner;
import static org.assertj.core.api.Assertions.assertThat;
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

        @Test
        @DisplayName("should reject if owner passed is null")
        void should_reject_if_owner_passed_is_null() {
            Animal animal = anAnimal().build();

            assertThatIllegalArgumentException().isThrownBy(() -> {
                animal.beAdoptedBy(null);
            });
        }
        
        @Test
        @DisplayName("should return false if owner can not support financially the animal")
        void should_return_false_if_owner_can_not_support_financially_the_animal() {
            Animal animal = anAnimal().withMonthlyCost(new BigDecimal("1000")).build();
            Owner owner = anOwner().withRemuneration(new BigDecimal("999.99")).build();

            assertThat(animal.beAdoptedBy(owner)).isFalse();
        }

        @Test
        @DisplayName("should return true if owner can support financially the animal")
        void should_return_true_if_owner_can_support_financially_the_animal() {
            Animal animal = anAnimal().withMonthlyCost(new BigDecimal("1000")).build();
            Owner owner = anOwner().withRemuneration(new BigDecimal("1000")).build();

            assertThat(animal.beAdoptedBy(owner)).isTrue();
        }

        @Test
        @DisplayName("should register owner and adopt datetime if owner can support financially the animal")
        void should_register_owner_and_adopt_datetime_if_owner_can_support_financially_the_animal() {
            Animal animal = anAnimal().withMonthlyCost(new BigDecimal("1000")).build();
            Owner owner = anOwner().withRemuneration(new BigDecimal("1000")).build();

            boolean adopted = animal.beAdoptedBy(owner);
            assertThat(adopted).isTrue();
            assertThat(ReflectionTestUtils.getField(animal, "owner")).isEqualTo(owner);
            assertThat(ReflectionTestUtils.getField(animal, "adoptedAt")).isNotNull();
        }
    }
}