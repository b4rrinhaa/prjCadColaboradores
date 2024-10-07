package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Colaborador;
import com.example.demo.services.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @PostMapping
    public Colaborador createColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.saveColaborador(colaborador);
    }

    @GetMapping
    public List<Colaborador> getAllColaboradores() {
        return colaboradorService.getAllColaboradores();
    }

    @GetMapping("/{id}")
    public Colaborador getColaborador(@PathVariable Long id) {
        return colaboradorService.getColaboradorById(id);
    }

    @PutMapping("/{id}")
    public Colaborador updateColaborador(@PathVariable Long id, @RequestBody Colaborador colaboradorDetails) {
        return colaboradorService.updateColaborador(id, colaboradorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteColaborador(@PathVariable Long id) {
        colaboradorService.deleteColaborador(id);
    }
}
