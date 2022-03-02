package br.com.alura.dojoadopt.owner;

public enum HomeKind {
    HOUSE("Casa"),
    APARTMENT("Apartamento"),
    HOUSE_WITH_YARD("Casa com quintal"),
    HOUSE_WITH_POOL("Casa com piscina"),
    FARM("Sítio");

    private String displayName;

    HomeKind(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
