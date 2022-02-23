package br.com.alura.dojoadopt;

public class AnimalView {

    private Long id;
    private String kind;
    private String size;
    private int ageInYears;
    private String photoUrl;
    private String name;

    public AnimalView(Animal animal) {
        id = animal.getId();
        name = animal.getName();
        kind = animal.getAnimalKind().getDisplayName();
        size = animal.getAnimalSize().getDisplayName();
        ageInYears = animal.getAgeInYears();
        photoUrl = animal.getPhotoUrl();
    }
}
