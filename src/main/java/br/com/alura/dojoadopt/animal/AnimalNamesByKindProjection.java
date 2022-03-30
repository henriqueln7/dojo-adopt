package br.com.alura.dojoadopt.animal;

import java.util.List;

public interface AnimalNamesByKindProjection {
    AnimalKind animalKind();
    List<String> names();
}
