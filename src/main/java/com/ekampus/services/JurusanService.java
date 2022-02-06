package com.ekampus.services;

import com.ekampus.models.entities.Fakultas;
import com.ekampus.models.entities.Jurusan;
import com.ekampus.models.repositories.FakultasRepo;
import com.ekampus.models.repositories.JurusanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JurusanService {
    @Autowired
    JurusanRepo jurusanRepo;
    @Autowired
    FakultasRepo fakultasRepo;

    public Iterable<Jurusan> findAll() {
        return jurusanRepo.findAll();
    }

    public void save(Jurusan jurusan) {
        jurusanRepo.save(jurusan);
    }

    public Jurusan findById(Integer id) {
        return jurusanRepo.findById(id).get();
    }

    public void destroy(Jurusan jurusan) {
        jurusanRepo.delete(jurusan);
    }

    public Iterable<Fakultas> allFakultas() {
        return fakultasRepo.findAll();
    }
}
