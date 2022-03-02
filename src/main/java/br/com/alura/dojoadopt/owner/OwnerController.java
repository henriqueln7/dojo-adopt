package br.com.alura.dojoadopt.owner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OwnerController {

    @GetMapping("/owners/new")
    public String createOwnerForm(CreateOwnerForm form) {
        return "owners/new";
    }

    @PostMapping("/owners")
    public void createOwner(CreateOwnerForm form) {
        System.out.println(form);
    }
}
