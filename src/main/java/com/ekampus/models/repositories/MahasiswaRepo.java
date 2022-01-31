package com.ekampus.models.repositories;

import com.ekampus.models.entities.Mahasiswa;
import org.springframework.data.repository.CrudRepository;

public interface MahasiswaRepo extends CrudRepository<Mahasiswa, Long> {
    @Q
}
