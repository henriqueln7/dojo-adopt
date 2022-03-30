package br.com.alura.dojoadopt.animal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    boolean existsByNameAndAnimalKind(String name, AnimalKind kind);

    default List<Animal> allThatCanBeAdopted() {
        return findAllByOwnerIsNull();
    }

    List<Animal> findAllByOwnerIsNull();

}
