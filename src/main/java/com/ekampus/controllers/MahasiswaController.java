package com.ekampus.controllers;

import com.ekampus.models.entities.Mahasiswa;
import com.ekampus.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping({"/mahasiswa"})
public class MahasiswaController {
    @Autowired
    MahasiswaService mahasiswaService;

    @GetMapping
    public String index(@RequestParam(value = "search", required = false) String search, Model model) {

        model.addAttribute("mahasiswas", mahasiswaService.all());
        return "mahasiswa/index";
    }

    @GetMapping("tambah-mahasiswa")
    public String create(Model model) {
        Mahasiswa mahasiswaBaru = new Mahasiswa();
        model.addAttribute("mahasiswa", mahasiswaBaru);

        return "mahasiswa/create";
    }

    @PostMapping()
    public String store(Mahasiswa mahasiswa) {
        mahasiswaService.store(mahasiswa);
        return "redirect:mahasiswa";
    }

    @GetMapping("edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        Mahasiswa mahasiswa = mahasiswaService.find(id);
        model.addAttribute("mahasiswa", mahasiswa);
        return "mahasiswa/edit";
    }

    @PostMapping("update")
    public String update(Mahasiswa mahasiswa) {
        mahasiswaService.update(mahasiswa);
        return "redirect:/mahasiswa";
    }

    @PostMapping("hapus")
    public String destroy(@RequestParam(name = "id") Long id) {
        mahasiswaService.destroy(id);
        return "redirect:/mahasiswa";
    }


}
