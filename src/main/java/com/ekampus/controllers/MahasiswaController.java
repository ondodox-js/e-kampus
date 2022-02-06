package com.ekampus.controllers;

import com.ekampus.models.entities.Mahasiswa;
import com.ekampus.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@Controller
@RequestMapping({"/mahasiswa"})
public class MahasiswaController {
    @Autowired
    MahasiswaService mahasiswaService;

    @GetMapping()
    public String index(@RequestParam(value = "search", required = false) String search, Model model) {
        try {
            model.addAttribute("mahasiswas", mahasiswaService.findAll(search));
            model.addAttribute("search", search);
            return "mahasiswa/index";
        } catch (Exception ignored) {
            model.addAttribute("mahasiswas", mahasiswaService.findAll());
            model.addAttribute("search", search);
        }
        return "mahasiswa/index";

    }

    @GetMapping("/{id}/show")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("mahasiswa", mahasiswaService.find(id));
        return "mahasiswa/show";
    }

    @GetMapping("create")
    public String create(Model model) {
        Mahasiswa mahasiswaBaru = new Mahasiswa();
        model.addAttribute("kumpulanJurusan", mahasiswaService.allJurusan());
        model.addAttribute("mahasiswa", mahasiswaBaru);

        return "mahasiswa/create";
    }

    @PostMapping("store")
    public String store(Mahasiswa mahasiswa) {
        mahasiswaService.store(mahasiswa);
        return "redirect:/mahasiswa";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("kumpulanJurusan", mahasiswaService.allJurusan());
        model.addAttribute("mahasiswa", mahasiswaService.find(id));
        return "mahasiswa/edit";
    }

    @PostMapping("update")
    public String update(Mahasiswa mahasiswa) {
        mahasiswaService.update(mahasiswa);
        return "redirect:/mahasiswa";
    }

    @PostMapping("destroy")
    public String destroy(Mahasiswa mahasiswa) {
        mahasiswaService.destroy(mahasiswa);
        return "redirect:/mahasiswa";
    }

}
