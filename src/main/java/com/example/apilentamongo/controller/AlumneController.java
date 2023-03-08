package com.example.apilentamongo.controller;


import com.example.apilentamongo.entities.Alumne;
import com.example.apilentamongo.repositories.AlumneDAO;
import com.example.apilentamongo.repositories.EmpresaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("api")
public class AlumneController {

    @Autowired
    AlumneDAO alumneDAO;
    @GetMapping("alumnes")
    public String alumnes(Model model){

        model.addAttribute("alumnes", alumneDAO.findAll());

        return "llista-alumnes.html";
    }
    @GetMapping("/alumnes/nou")
    public String mostrarFormulariProjecte(Model model) {

        Alumne alumne = new Alumne();
        model.addAttribute("alumne", alumne);


        return "nou-alumne.html";
    }

    @PostMapping("alumnes/alta")
    public String altaProjecte(Alumne alumne){
        alumneDAO.save(alumne);

        return "redirect:/api/alumnes";
    }
}
