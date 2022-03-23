package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.owner.Owner;
import org.junit.jupiter.api.*;

import static br.com.alura.dojoadopt.animal.AnimalBuilder.anAnimal;
import static br.com.alura.dojoadopt.animal.AnimalKind.*;
import static br.com.alura.dojoadopt.animal.AnimalSize.*;
import static br.com.alura.dojoadopt.owner.HomeKind.*;
import static br.com.alura.dojoadopt.owner.OwnerBuilder.anOwner;
import static org.assertj.core.api.Assertions.assertThat;

class AnimalKindTest {
    @Nested
    class Fish {
        @Test
        @DisplayName("should accept owner if owner lives in house with pool")
        void should_accept_owner_if_owner_lives_in_house_with_pool() {
            Owner owner = anOwner().withHomeKind(HOUSE_WITH_POOL).build();
            assertThat(FISH.accepts(owner)).isTrue();
        }

        @Test
        @DisplayName("should not accept owner if owner does not live in house with pool")
        void should_not_accept_owner_if_owner_does_not_live_in_house_with_pool() {
            Owner owner = anOwner().withHomeKind(HOUSE_WITH_YARD).build();
            assertThat(FISH.accepts(owner)).isFalse();
        }
    }

    @Nested
    class Reptile {
        @Test
        @DisplayName("should accept owner if owner lives in farm no matter if has dogs or cats")
        void should_accept_owner_if_owner_lives_in_farm_no_matter_if_has_dogs_or_cats() {
            Animal cat = anAnimal().withKind(CAT).build();
            Animal dog = anAnimal().withKind(DOG).build();
            Owner owner = anOwner().withHomeKind(FARM).withAnimals(cat, dog).build();

            assertThat(REPTILE.accepts(owner)).isTrue();
        }

        @Test
        @DisplayName("should accept owner if owner does not live in farm and has no dogs or cats")
        void should_accept_owner_if_owner_does_not_live_in_farm_and_has_no_dogs_or_cats() {
            Owner owner = anOwner().withHomeKind(HOUSE).build();

            assertThat(REPTILE.accepts(owner)).isTrue();
        }

        @Test
        @DisplayName("should reject owner if owner does not live in farm and has cats")
        void should_reject_owner_if_owner_does_not_live_in_farm_and_has_cats() {
            Animal cat = anAnimal().withKind(CAT).build();
            Owner owner = anOwner().withHomeKind(HOUSE).withAnimals(cat).build();

            assertThat(REPTILE.accepts(owner)).isFalse();
        }

        @Test
        @DisplayName("should reject owner if owner does not live in farm and has dogs")
        void should_reject_owner_if_owner_does_not_live_in_farm_and_has_dogs() {
            Animal dog = anAnimal().withKind(DOG).build();
            Owner owner = anOwner().withHomeKind(HOUSE).withAnimals(dog).build();

            assertThat(REPTILE.accepts(owner)).isFalse();
        }
    }

    @Nested
    class Dog {

        @Test
        @DisplayName("should accept owner if owner does not live in apartment and has a dog with size BIG or GIANT")
        void should_accept_owner_if_owner_does_not_live_in_apartment_and_has_a_dog_with_size_big_or_giant() {
            Animal bigDog = anAnimal().withKind(DOG).withSize(BIG).build();
            Animal giantDog = anAnimal().withKind(DOG).withSize(GIANT).build();
            Owner owner = anOwner().withHomeKind(HOUSE).withAnimals(bigDog, giantDog).build();

            assertThat(DOG.accepts(owner)).isTrue();
        }

        @Test
        @DisplayName("should accept owner if owner lives in apartment and has no dog with size BIG or GIANT")
        void should_accept_owner_if_owner_lives_in_apartment_and_has_no_dog_with_size_big_or_giant() {
            Animal mediumDog = anAnimal().withKind(DOG).withSize(MEDIUM).build();
            Owner owner = anOwner().withHomeKind(APARTMENT).withAnimals(mediumDog).build();

            assertThat(DOG.accepts(owner)).isTrue();
        }

        @Test
        @DisplayName("should reject owner if owner does not live in apartment and has dog with size BIG or GIANT")
        void should_reject_owner_if_owner_does_not_live_in_apartment_and_has_dog_with_size_big_or_giant() {
            Animal giantDog = anAnimal().withKind(DOG).withSize(GIANT).build();
            Owner owner = anOwner().withHomeKind(APARTMENT).withAnimals(giantDog).build();

            assertThat(DOG.accepts(owner)).isFalse();
        }


    }
}