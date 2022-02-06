package com.ekampus.services;

import com.ekampus.models.entities.Jurusan;
import com.ekampus.models.entities.Mahasiswa;
import com.ekampus.models.repositories.JurusanRepo;
import com.ekampus.models.repositories.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MahasiswaService {
    @Autowired
    private MahasiswaRepo mahasiswaRepo;
    @Autowired
    private JurusanRepo jurusanRepo;

    public Iterable<Mahasiswa> findAll() {
        return mahasiswaRepo.findAll();
    }

    public void store(Mahasiswa mahasiswa) {
        try {
            mahasiswaRepo.save(mahasiswa);
        } catch (Exception ignored) {
        }
    }

    public void destroy(Mahasiswa mahasiswa) {
        mahasiswaRepo.delete(mahasiswa);
    }

    public Mahasiswa find(Integer id) {
        return mahasiswaRepo.findById(id).get();
    }

    public void update(Mahasiswa mahasiswa) {
        mahasiswaRepo.save(mahasiswa);
    }

    public Iterable<Jurusan> allJurusan() {
        return jurusanRepo.findAll();
    }

    public Iterable<Mahasiswa> findAll(String string) {
        if (string.equals("")) {
            return mahasiswaRepo.findAll();
        } else {
            return mahasiswaRepo.findBy(string);
        }
    }


}
