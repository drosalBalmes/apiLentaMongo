package com.example.apilentamongo.repositories;

import com.example.apilentamongo.entities.Alumne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumneDAO extends JpaRepository<Alumne,Long> {
}
