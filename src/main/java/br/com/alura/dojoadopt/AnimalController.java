package br.com.alura.dojoadopt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalController {

    @GetMapping("/animals/new")
    public String newAnimalForm() {
        return "animals/new";
    }
}
