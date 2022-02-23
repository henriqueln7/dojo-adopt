package br.com.alura.dojoadopt;

public enum AnimalSize {
    MINI("Mini"),
    SMALL("Pequeno"),
    MEDIUM("Médio"),
    BIG("Grande"),
    GIANT("Gigante");

    private String displayName;

    AnimalSize(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
