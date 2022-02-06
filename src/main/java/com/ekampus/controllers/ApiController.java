package com.ekampus.controllers;

import com.ekampus.models.entities.Admin;
import com.ekampus.models.entities.Fakultas;
import com.ekampus.models.entities.Jurusan;
import com.ekampus.models.entities.Mahasiswa;
import com.ekampus.models.repositories.FakultasRepo;
import com.ekampus.models.repositories.JurusanRepo;
import com.ekampus.services.AdminService;
import com.ekampus.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    FakultasRepo fakultasRepo;
    @Autowired
    JurusanRepo jurusanRepo;
    @Autowired
    MahasiswaService mahasiswaService;
    @Autowired
    AdminService adminService;

    @GetMapping("fakultas")
    public Iterable<Fakultas> allFakultas() {
        return fakultasRepo.findAll();
    }

    @GetMapping("jurusan")
    public Iterable<Jurusan> allJurusan() {
        return jurusanRepo.findAll();
    }

    @GetMapping("mahasiswa")
    public Iterable<Mahasiswa> findBy(@RequestParam(name = "search", required = false) String search) {
        return mahasiswaService.findAll(search);
    }

    @GetMapping("count-fakultas")
    public Long countFakultas(@RequestParam String id) {
        try {
            return mahasiswaService.findAll(id).spliterator().estimateSize();
        } catch (Exception e) {
            return 0L;
        }
    }

    @GetMapping("cek-admin")
    public boolean cek(@RequestBody Admin admin) {
        try {
            return adminService.cekMasuk(admin);
        } catch (Exception ignored) {
            return false;
        }
    }


}
