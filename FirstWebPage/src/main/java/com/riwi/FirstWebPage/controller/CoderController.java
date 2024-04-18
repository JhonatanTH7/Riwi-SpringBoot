package com.riwi.FirstWebPage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.FirstWebPage.entity.Coder;
import com.riwi.FirstWebPage.services.CoderService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    // Método para mostrar la vista y enviarle la vista de Coders
    @GetMapping
    public String showViewGetAll(Model objModel) {
        // Llamo al servicio y guardo la lista de Coders
        List<Coder> list = this.objCoderService.findAll();
        objModel.addAttribute("coderList", list);
        // Se debe retornar el nombre exacto de la vista html
        return "ViewCoder";
    }

    // Método para capturar los datos ingresados en el Form
    @GetMapping("/Form")
    public String showViewForm(Model objModel) {
        objModel.addAttribute("coder", new Coder());
        objModel.addAttribute("action", "/coder/create");
        return "ViewForm";
    }

    // Método para insertar un coder mediante el verbo POST
    // @ModelAttribute se encarga de obtener la información enviada desde la vista
    @PostMapping("/coder/create")
    public String createCoder(@ModelAttribute Coder objCoder) {
        // Llamamos al servicio enviandole el coder a insertar
        this.objCoderService.insert(objCoder);
        return "redirect:/";
    }

    // Método para mostrar el formulario de actualizar coder
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Long id, Model objModel) {
        Coder objCoderFind = this.objCoderService.finById(id);
        objModel.addAttribute("coder", objCoderFind);
        objModel.addAttribute("action", "/edit/" + id);
        return "ViewForm";
    }

    // Método para actualizar coder
    @PostMapping("/edit/{id}")
    public String postMethodName(@PathVariable Long id, @ModelAttribute Coder objCoder) {
        this.objCoderService.update(id, objCoder);
        return "redirect:/";
    }
}
