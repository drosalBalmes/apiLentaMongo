package com.example.apilentamongo.repositories;

import com.example.apilentamongo.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaDAO extends JpaRepository<Empresa,String> {
}
