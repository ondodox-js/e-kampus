package com.ekampus.controllers;

import com.ekampus.models.entities.Barang;
import com.ekampus.services.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/barang")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @GetMapping
    public String index(Model model){
        Iterable<Barang> barangs = barangService.all();
        model.addAttribute("barangs", barangs);
        return "barang/index";
    }
    @GetMapping("tambah-barang")
    public String create(Model model){
        String title = "Tambah barang";
        model.addAttribute("title", title);
        return "barang/create";
    }
    @PostMapping("")
    public String destroy(@RequestParam Long id){
        barangService.destroy(id);
        return "redirect:barang";
    }

}
