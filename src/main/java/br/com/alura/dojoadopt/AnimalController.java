package br.com.alura.dojoadopt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {

    @GetMapping("/animals/new")
    public String createAnimalForm(Model model) {
        model.addAttribute("animalSizes", AnimalSize.values());
        model.addAttribute("animalKinds", AnimalKind.values());
        return "animals/new";
    }

    @PostMapping("/animals")
    public void createAnimal(CreateAnimalForm form) {

    }
}
