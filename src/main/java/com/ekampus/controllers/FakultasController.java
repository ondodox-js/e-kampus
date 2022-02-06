package com.ekampus.controllers;

import com.ekampus.dto.FakultasData;
import com.ekampus.models.entities.Fakultas;
import com.ekampus.models.repositories.FakultasRepo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("fakultas")
public class FakultasController {
    @Autowired
    private FakultasRepo fakultasRepo;

    @GetMapping
    private String index(Model model) {
        model.addAttribute("kumpulanFakultas", fakultasRepo.findAll());
        return "fakultas/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        Fakultas fakultas = new Fakultas();
        model.addAttribute("fakultas", fakultas);
        return "fakultas/create";
    }

    @PostMapping("store")
    public String store(Fakultas fakultas) {
        fakultasRepo.save(fakultas);
        return "redirect:/fakultas";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Fakultas fakultas = fakultasRepo.findById(id).get();
        model.addAttribute("fakultas", fakultas);
        return "fakultas/edit";
    }

    @PostMapping("update")
    public String update(Fakultas fakultas) {
        fakultasRepo.save(fakultas);
        return "redirect:/fakultas";
    }

    @PostMapping("/{id}/destroy")
    public String destroy(@PathVariable Integer id) {
        if (fakultasRepo.countById(id) < 1) {
            fakultasRepo.deleteById(id);
        }
        return "redirect:/fakultas";
    }

}
