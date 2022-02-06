package com.ekampus.controllers;

import com.ekampus.models.entities.Admin;
import com.ekampus.services.AdminService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public String masuk(Admin akunAkses, Model model) {
        model.addAttribute("akun", akunAkses);
        return "masuk";
    }

    @PostMapping("masuk")
    public String aksiMasuk(Admin akun, Model model) {
        if (adminService.cekMasuk(akun)) {
            return "redirect:/dashboard";
        }
        model.addAttribute("pesan", "Nama pengguna atau kata sandi salah!");
        model.addAttribute("akun", new Admin());
        return "masuk";
    }

    @GetMapping("daftar")
    public String daftar(Admin admin, Model model) {
        model.addAttribute("akun", admin);
        return "daftar";
    }

    @PostMapping("daftar")
    public String daftarAksi(Admin akun, Model model) {
        if (!adminService.cekNamaPengguna(akun) || !adminService.tambahAkun(akun)) {
            model.addAttribute("pesan", "Nama pengguna sudah terdaftar!");
            model.addAttribute("akun", akun);
            return "daftar";
        }

        model.addAttribute("akun", akun);
        return "success";
    }

    @PostMapping("/keluar")
    public String aksiKeluar() {
        return "redirect:/";
    }
}
