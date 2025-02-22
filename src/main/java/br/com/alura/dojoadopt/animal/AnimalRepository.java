package br.com.alura.dojoadopt.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    boolean existsByNameAndAnimalKind(String name, AnimalKind kind);

    default List<Animal> allThatCanBeAdopted() {
        return findAllByOwnerIsNull();
    }

    List<Animal> findAllByOwnerIsNull();

    @Query(value = """
    SELECT a.animal_kind as animalKind, GROUP_CONCAT(a.name) as namesConcat
    FROM animal a
    GROUP BY a.animal_kind
""", nativeQuery = true)
    List<AnimalNamesByKindProjection> namesByKind();

    @Query(value = """
    SELECT a.animal_kind as kind, COUNT(1) as quantity, AVG(a.monthly_cost) as averageMonthlyCost
    FROM animal a
    GROUP BY a.animal_kind
""", nativeQuery = true)
    List<MonthlyCostByKindProjection> monthlyCostsByKind();

    @Query(value = """
    SELECT o.name as ownerName, IFNULL(SUM(a.monthly_cost), 0) AS monthlyTotalExpenses
    FROM owner o
        LEFT JOIN animal a on a.owner_id = o.id
    GROUP BY o.id
    ORDER BY monthlyTotalExpenses DESC
""", nativeQuery = true)
    List<MonthlyExpensesByOwnerProjection> monthlyExpensesByOwner();
}
