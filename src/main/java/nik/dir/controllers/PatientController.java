package nik.dir.controllers;

import nik.dir.dao.NormaDAO;
import nik.dir.dao.PatientDAO;
import nik.dir.models.Analysis;
import nik.dir.models.Norma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private NormaDAO normaDAO;
    @Autowired
    private PatientDAO patientDAO;
    @Autowired
    private Analysis analysis;
    private void NormaWork()
    {
        normaDAO.setTabl("SELECT * FROM normal");
        patientDAO.setTabl("SELECT * FROM patients");
        normaDAO.Reload();
        normaDAO.all();
    }
    @GetMapping("/list")
    public String Patients(Model model)
    {
        NormaWork();
        patientDAO.Reload();
        model.addAttribute("patients", patientDAO.all());
        model.addAttribute("back", "/untitled15_war/main");
        model.addAttribute("norm", "/untitled15_war/normal");
        model.addAttribute("analys","/untitled15_war/patients/analys");
        model.addAttribute("patien", "/untitled15_war/patients/list");
        return "patients/list";
    }
    @GetMapping("/analys")
    public String Analys(Model model)
    {
        model.addAttribute("normal", new Norma());
        model.addAttribute("back", "/untitled15_war/main");
        model.addAttribute("norm", "/untitled15_war/normal");
        model.addAttribute("analys","/untitled15_war/patients/analys");
        model.addAttribute("patien", "/untitled15_war/patients/list");
        return "patients/analys";
    }
    @PostMapping()
    public String Create(@ModelAttribute("normal") Norma patient)
    {
        NormaWork();
        patient.setResult(analysis.Process(normaDAO, patient));
        patientDAO.save(patient);
        patientDAO.Reload();
        return "redirect:patients/list";

    }
    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("patient", patientDAO.show(id));
        model.addAttribute("norm", "/untitled15_war/normal");
        model.addAttribute("analys","/untitled15_war/patients/analys");
        model.addAttribute("patien", "/untitled15_war/patients/list");
        return "patients/index";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id)
    {
        patientDAO.setTabl("SELECT * FROM patients");
        patientDAO.Reload();
        model.addAttribute("patient", patientDAO.show(id));
        model.addAttribute("norm", "/untitled15_war/normal");
        model.addAttribute("analys","/untitled15_war/patients/analys");
        model.addAttribute("patien", "/untitled15_war/patients/list");
        return "patients/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("patient") Norma patient, @PathVariable("id") int id)
    {
        NormaWork();
        patient.setResult(analysis.Process(normaDAO, patient));
        patientDAO.setTabl("SELECT * FROM patients");
        patientDAO.update(id, patient);
        patientDAO.Reload();
        return "redirect:list";

    }
    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id)
    {
        patientDAO.setTabl("SELECT * FROM patients");
        patientDAO.delete(id);
        patientDAO.Reload();
        return "redirect:list";
    }   
}
