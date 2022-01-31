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

//    public boolean cekMasuk(Admin admin) {
////        if (admin.getNamaPengguna())
//    }
}
