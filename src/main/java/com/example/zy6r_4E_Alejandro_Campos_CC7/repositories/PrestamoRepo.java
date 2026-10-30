package com.example.zy6r_4E_Alejandro_Campos_CC7.repositories;

import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepo extends JpaRepository<Prestamo,Long> {
}
