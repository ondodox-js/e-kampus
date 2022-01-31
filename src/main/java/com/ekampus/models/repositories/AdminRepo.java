package com.ekampus.models.repositories;

import com.ekampus.models.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, Long> {
}
