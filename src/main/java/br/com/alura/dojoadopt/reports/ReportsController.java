package br.com.alura.dojoadopt.reports;

import br.com.alura.dojoadopt.animal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Controller
public class ReportsController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/reports")
    public String reports() {
        return "reports/list";
    }

    @GetMapping("/reports/namesByKind")
    public String namesByKind(Model model) {
        Map<AnimalKind, List<String>> namesByKind = animalRepository.findAll()
                                                                    .stream()
                                                                    .collect(groupingBy(Animal::getAnimalKind, mapping(Animal::getName, toList())));
        model.addAttribute("namesByKind", namesByKind);

        return "reports/namesByKind";
    }
}
