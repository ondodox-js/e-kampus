package com.ekampus.controllers;

import com.ekampus.dto.JurusanData;
import com.ekampus.models.entities.Fakultas;
import com.ekampus.models.entities.Jurusan;
import com.ekampus.models.repositories.JurusanRepo;
import com.ekampus.services.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/jurusan")
public class JurusanController {
    @Autowired
    private JurusanService jurusanService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("kumpulanJurusan", jurusanService.findAll());
        return "jurusan/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        Jurusan jurusan = new Jurusan();
        model.addAttribute("kumpulanFakultas", jurusanService.allFakultas());
        model.addAttribute("jurusan", jurusan);

        return "jurusan/create";
    }

    @PostMapping("store")
    public String store(Jurusan jurusan) {
        jurusanService.save(jurusan);
        return "redirect:/jurusan";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Jurusan jurusan = jurusanService.findById(id);
        model.addAttribute("jurusan", jurusan);
        model.addAttribute("kumpulanFakultas", jurusanService.allFakultas());
        return "jurusan/edit";
    }

    @PostMapping("update")
    public String update(Jurusan jurusan) {
        jurusanService.save(jurusan);
        return "redirect:/jurusan";
    }

    @PostMapping("/destroy")
    public String destroy(Jurusan jurusan) {
        jurusanService.destroy(jurusan);
        return "redirect:/jurusan";
    }

}
