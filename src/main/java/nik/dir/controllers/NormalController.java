package nik.dir.controllers;

import nik.dir.dao.NormaDAO;
import nik.dir.dao.PatientDAO;
import nik.dir.models.Analysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/normal")
public class NormalController {
    @Autowired
    private NormaDAO normaDAO;

    @Autowired
    private PatientDAO patientDAO;
    @Autowired
    private Analysis analysis;
    @GetMapping
    public String show(Model model)
    {
        normaDAO.setTabl("SELECT * FROM normal");
        normaDAO.Reload();
        model.addAttribute("normal", normaDAO.all());
        model.addAttribute("back", "/untitled15_war/main");
        model.addAttribute("norm", "/untitled15_war/normal");
        model.addAttribute("analys","/untitled15_war/patients/analys");
        model.addAttribute("patients", "/untitled15_war/patients/list");
        return "normal/show";

    }
}
