package br.com.alura.dojoadopt.animal;

public enum AnimalKind {
    FISH("Peixe"),
    REPTILE("Réptil"),
    DOG("Cachorro"),
    CAT("Gato"),
    BIRD("Pássarasalto"),
    EXOTIC("Exótico");

    private String displayName;

    AnimalKind(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
