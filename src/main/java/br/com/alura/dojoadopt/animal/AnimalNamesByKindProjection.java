package br.com.alura.dojoadopt.animal;

import java.util.List;

public interface AnimalNamesByKindProjection {
    AnimalKind getAnimalKind();
    String getNamesConcat();

    default String getKindDisplayName() {
        return getAnimalKind().getDisplayName();
    }

    default List<String> getNames() {
        return List.of(getNamesConcat().split(","));
    }
}
