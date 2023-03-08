package com.example.apilentamongo.controller;

import com.example.apilentamongo.entities.Alumne;
import com.example.apilentamongo.entities.Empresa;
import com.example.apilentamongo.repositories.EmpresaDAO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("api")
public class EmpresaController {

    @Autowired
    EmpresaDAO empresaDAO;
    @GetMapping("empreses")
    public String empreses(Model model){

        model.addAttribute("empreses", empresaDAO.findAll());

        return "llista-empreses.html";
    }

    @GetMapping("/empreses/nou")
    public String mostrarFormulariEmpresa(Model model) {

        Empresa empresa = new Empresa();
        model.addAttribute("empresa", empresa);


        return "nou-empresa.html";
    }

    @PostMapping("empresa/alta")
    public String altaEmpresa(Empresa empresa){
        empresaDAO.save(empresa);

        return "redirect:/api/empreses";
    }
}
