package com.ekampus.services;

import com.ekampus.models.entities.Admin;
import com.ekampus.models.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public boolean cekMasuk(Admin loginData) {
        try {
            Admin admin = adminRepo.findByNamaPengguna(loginData.getNamaPengguna());
            return loginData.getKataSandi().equals(admin.getKataSandi());
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean cekNamaPengguna(Admin data) {
        return adminRepo.countAdminByNamaPengguna(data.getNamaPengguna()) == 0;
    }

    public boolean tambahAkun(Admin data) {
        try {
            adminRepo.save(data);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
