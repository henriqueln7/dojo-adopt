package br.com.alura.dojoadopt.owner;

public record OwnerView(Long id, String name, String cpf, String photoUrl) {

    public OwnerView(Owner owner) {
        this(owner.getId(), owner.getName(), owner.getCpf(), owner.getPhotoUrl());
    }

}
