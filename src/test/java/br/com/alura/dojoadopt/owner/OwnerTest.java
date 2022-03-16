package br.com.alura.dojoadopt.owner;

import br.com.alura.dojoadopt.animal.Animal;
import br.com.alura.dojoadopt.animal.AnimalBuilder;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerTest {
    @Nested
    class CanSupport {
        @Test
        @DisplayName("should return true if owner has no animals and remuneration enough to cover monthly costs from animal")
        void should_return_true_if_owner_has_no_animals_and_remuneration_enough_to_cover_monthly_costs_from_animal() {
            Owner owner = OwnerBuilder.anOwner().withRemuneration(new BigDecimal("100")).build();
            Animal animal = AnimalBuilder.anAnimal().withMonthlyCost(new BigDecimal("100")).build();

            assertThat(owner.canSupport(animal)).isTrue();
        }

        @Test
        @DisplayName("should return false if owner has no animals and remuneration not enough to cover monthly costs from animal")
        void should_return_false_if_owner_has_no_animals_and_remuneration_not_enough_to_cover_monthly_costs_from_animal() {
            Owner owner = OwnerBuilder.anOwner().withRemuneration(new BigDecimal("100")).build();
            Animal animal = AnimalBuilder.anAnimal().withMonthlyCost(new BigDecimal("100.01")).build();

            assertThat(owner.canSupport(animal)).isFalse();

        }
    }
}