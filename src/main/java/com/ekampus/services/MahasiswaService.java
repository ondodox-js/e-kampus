package com.ekampus.services;

import com.ekampus.models.entities.Mahasiswa;
import com.ekampus.models.repositories.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MahasiswaService {
    @Autowired
    private MahasiswaRepo mahasiswaRepo;

    public Iterable<Mahasiswa> all() {
        return mahasiswaRepo.findAll();
    }


    public void store(Mahasiswa mahasiswa) {
        try {
            mahasiswaRepo.save(mahasiswa);
        } catch (Exception ignored) {
        }
    }

    public void destroy(Long id) {
        mahasiswaRepo.deleteById(id);
    }

    public Mahasiswa find(Long id) {
        return mahasiswaRepo.findById(id).get();
    }

    public void update(Mahasiswa mahasiswa) {
//        Mahasiswa mahasiswa = mahasiswaRepo.findById(mahasiswaUpdate.getId()).get();
        mahasiswaRepo.save(mahasiswa);
    }
}
