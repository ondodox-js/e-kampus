package com.ekampus.models.repositories;

import com.ekampus.models.entities.Barang;
import org.springframework.data.repository.CrudRepository;

public interface BarangRepo extends CrudRepository<Barang, Long> {
}
