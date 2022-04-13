package br.com.alura.dojoadopt.reports;

import br.com.alura.dojoadopt.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("namesByKind", animalRepository.namesByKind());
        return "reports/namesByKind";
    }

    @GetMapping("/reports/monthlyCostsByKind")
    public String monthlyCostsByKind(Model model) {
        model.addAttribute("monthlyCostsByKind", animalRepository.monthlyCostsByKind());
        return "reports/monthlyCostsByKind";
    }

    @GetMapping("/reports/monthlyExpensesByOwner")
    public String monthlyExpensesByOwner(Model model) {
        model.addAttribute("monthlyExpensesByOwner", animalRepository.monthlyExpensesByOwner());
        return "reports/monthlyExpensesByOwner";
    }
}
