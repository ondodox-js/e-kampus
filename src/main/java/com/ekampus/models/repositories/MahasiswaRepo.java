package com.ekampus.models.repositories;

import com.ekampus.models.entities.Mahasiswa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MahasiswaRepo extends CrudRepository<Mahasiswa, Integer> {

    @Query(value = "SELECT * FROM Mahasiswa WHERE nama_mahasiswa LIKE %?1%", nativeQuery = true)
    Iterable<Mahasiswa> findBy(String search);
}
