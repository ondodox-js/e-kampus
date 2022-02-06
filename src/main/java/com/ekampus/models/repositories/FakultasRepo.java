package com.ekampus.models.repositories;

import com.ekampus.models.entities.Fakultas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FakultasRepo extends CrudRepository<Fakultas, Integer> {
    @Query(value = "SELECT count (e) FROM Jurusan e WHERE e.fakultas.id = ?1")
    Long countById(Integer id_fakultas);

}
