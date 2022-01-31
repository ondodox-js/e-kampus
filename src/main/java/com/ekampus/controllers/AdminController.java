package com.ekampus.controllers;

import com.ekampus.models.entities.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
    @GetMapping
    public String masuk(Admin akunAkses, Model model) {
        model.addAttribute("akun", akunAkses);
        return "masuk";
    }

    @PostMapping("/masuk")
    public String aksiMasuk(Admin akun) {
        System.out.println(akun.getNamaPengguna());
        return "redirect:/mahasiswa";
    }

    @PostMapping("/keluar")
    public String aksiKeluar() {
        return "redirect:/";
    }
}
