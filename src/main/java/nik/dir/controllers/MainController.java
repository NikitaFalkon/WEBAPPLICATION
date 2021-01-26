package nik.dir.controllers;

import nik.dir.dao.PatientDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping
    public String First(Model model){
        model.addAttribute("normal", "/untitled15_war/normal");
        model.addAttribute("analys","/untitled15_war/patients/analys");
        model.addAttribute("patients", "/untitled15_war/patients/list");
        return "main/starting";
    }

}
