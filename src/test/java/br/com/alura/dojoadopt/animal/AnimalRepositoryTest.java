package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.owner.Owner;
import br.com.alura.dojoadopt.owner.OwnerBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;

import static br.com.alura.dojoadopt.animal.AnimalBuilder.anAnimal;
import static br.com.alura.dojoadopt.animal.AnimalKind.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AnimalRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnimalRepository animalRepository;

    @Nested
    class NamesByKind {
        @Test
        @DisplayName("should return names by kind correctly")
        void should_return_names_by_kind_correctly() {
            save(anAnimal().withKind(REPTILE).withName("Zezinho"));
            save(anAnimal().withKind(REPTILE).withName("Zé"));
            save(anAnimal().withKind(CAT).withName("Berranteiro"));
            save(anAnimal().withKind(DOG).withName("Matador de onça"));

            assertThat(animalRepository.namesByKind()).satisfiesExactlyInAnyOrder(projection -> {
                assertThat(projection.getAnimalKind()).isEqualTo(REPTILE);
                assertThat(projection.getNames()).containsExactly("Zezinho", "Zé");
            }, projection -> {
                assertThat(projection.getAnimalKind()).isEqualTo(CAT);
                assertThat(projection.getNames()).containsExactly("Berranteiro");
            }, projection -> {
                assertThat(projection.getAnimalKind()).isEqualTo(DOG);
                assertThat(projection.getNames()).containsExactly("Matador de onça");
            });

        }
    }

    @Nested
    class MonthlyCostsByKind {
        @Test
        @DisplayName("should return average monthly cost and quantity by kind correctly ")
        void should_return_average_monthly_cost_and_quantity_by_kind_correctly() {
            Animal zezinho = save(anAnimal().withKind(REPTILE).withName("Zezinho").withMonthlyCost(new BigDecimal(50)));
            Animal ze = save(anAnimal().withKind(REPTILE).withName("Zé").withMonthlyCost(new BigDecimal(100)));
            Animal berranteiro = save(anAnimal().withKind(CAT).withName("Berranteiro").withMonthlyCost(new BigDecimal(200)));
            Animal matadorDeOnca = save(anAnimal().withKind(DOG).withName("Matador de onça").withMonthlyCost(new BigDecimal(300)));

            assertThat(animalRepository.monthlyCostsByKind()).satisfiesExactlyInAnyOrder(projection -> {
                assertThat(projection.getKind()).isEqualTo(REPTILE);
                assertThat(projection.getAverageMonthlyCost()).isEqualByComparingTo("75.00");
                assertThat(projection.getQuantity()).isEqualTo(2);
            }, projection -> {
                assertThat(projection.getKind()).isEqualTo(CAT);
                assertThat(projection.getAverageMonthlyCost()).isEqualByComparingTo("200.00");
                assertThat(projection.getQuantity()).isEqualTo(1);
            }, projection -> {
                assertThat(projection.getKind()).isEqualTo(DOG);
                assertThat(projection.getAverageMonthlyCost()).isEqualByComparingTo("300.00");
                assertThat(projection.getQuantity()).isEqualTo(1);
            });
        }
    }

    @Nested
    class MonthlyExpensesByOwner {
        @Test
        @DisplayName("should return average monthly expenses by owner correctly")
        void should_return_average_monthly_expenses_by_owner_correctly() {

            Owner caio = OwnerBuilder.anOwner()
                                     .withName("Caio")
                                     .build();
            Owner maria = OwnerBuilder.anOwner().withName("Maria").build();
            Owner gabriel = OwnerBuilder.anOwner().withName("Gabriel").build();
            Owner romulo = OwnerBuilder.anOwner().withName("Rômulo").build();
            entityManager.persist(caio);
            entityManager.persist(gabriel);
            entityManager.persist(maria);
            entityManager.persist(romulo);
            Animal animal300 = anAnimal().withMonthlyCost(new BigDecimal(300)).build();
            Animal animal200 = anAnimal().withMonthlyCost(new BigDecimal(200)).build();
            Animal animal50 = anAnimal().withMonthlyCost(new BigDecimal(50)).build();
            Animal animal100 = anAnimal().withMonthlyCost(new BigDecimal(100)).build();

            entityManager.persist(animal300);
            entityManager.persist(animal200);
            entityManager.persist(animal50);
            entityManager.persist(animal100);

            animal50.beAdoptedBy(caio);
            animal100.beAdoptedBy(caio);
            animal200.beAdoptedBy(maria);
            animal300.beAdoptedBy(gabriel);

            entityManager.refresh(caio);
            entityManager.refresh(maria);
            entityManager.refresh(gabriel);
            entityManager.refresh(romulo);

            assertThat(animalRepository.monthlyExpensesByOwner()).satisfiesExactly(projection -> {
                assertThat(projection.getOwnerName()).isEqualTo("Gabriel");
                assertThat(projection.getMonthlyTotalExpenses()).isEqualByComparingTo("300.00");
            }, projection -> {
                assertThat(projection.getOwnerName()).isEqualTo("Maria");
                assertThat(projection.getMonthlyTotalExpenses()).isEqualByComparingTo("200.00");
            }, projection -> {
                assertThat(projection.getOwnerName()).isEqualTo("Caio");
                assertThat(projection.getMonthlyTotalExpenses()).isEqualByComparingTo("150.00");
            }, projection -> {
                assertThat(projection.getOwnerName()).isEqualTo("Rômulo");
                assertThat(projection.getMonthlyTotalExpenses()).isEqualByComparingTo("0.00");
            });
        }
    }


    private Animal save(AnimalBuilder animalBuilder) {
        Animal animal = animalBuilder.build();
        entityManager.persist(animal);
        return animal;
    }
}