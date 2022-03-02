package br.com.alura.dojoadopt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    boolean existsByNameAndAnimalKind(String name, AnimalKind kind);
}
