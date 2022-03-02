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

    public Long getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getSize() {
        return size;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getName() {
        return name;
    }
}
