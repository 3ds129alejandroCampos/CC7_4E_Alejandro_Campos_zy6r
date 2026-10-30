package com.example.zy6r_4E_Alejandro_Campos_CC7.repositories;

import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideojuegoRepo extends JpaRepository<Videojuego,Long> {


}
