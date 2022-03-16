package br.com.alura.dojoadopt.adoptions;

import br.com.alura.dojoadopt.animal.Animal;
import br.com.alura.dojoadopt.animal.AnimalRepository;
import br.com.alura.dojoadopt.owner.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;

@Controller
public class AdoptionController {

    private final AnimalRepository animalRepository;
    private final OwnerRepository ownerRepository;

    public AdoptionController(AnimalRepository animalRepository, OwnerRepository ownerRepository) {
        this.animalRepository = animalRepository;
        this.ownerRepository = ownerRepository;
    }

    @PostMapping("/adoptions")
    @Transactional
    public String newAdoption(NewAdoptionForm form, RedirectAttributes redirectAttributes) {
        Animal animal = animalRepository.findById(form.animalId()).orElseThrow();
        Owner owner = ownerRepository.findById(form.ownerId()).orElseThrow();

        boolean couldBeAdopted = animal.beAdoptedBy(owner);

        if (!couldBeAdopted) {
            redirectAttributes.addFlashAttribute("adoptError", "Puts cara você não tem grana pra sustentar o bicho!!!!");
        }

        redirectAttributes.addFlashAttribute("adoptSuccess", "Que coisa maravilinda! O animal " + animal.getName() + " foi adotado com sucesso");
        return "redirect:/owners/" + owner.getId();
    }
}
