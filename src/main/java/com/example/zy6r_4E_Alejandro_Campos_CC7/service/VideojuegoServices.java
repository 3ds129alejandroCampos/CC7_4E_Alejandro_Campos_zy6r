package com.example.zy6r_4E_Alejandro_Campos_CC7.service;

import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Videojuego;
import com.example.zy6r_4E_Alejandro_Campos_CC7.model.dto.request.RequestVideojuego;
import com.example.zy6r_4E_Alejandro_Campos_CC7.repositories.VideojuegoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoServices {

    private final VideojuegoRepo videojuegoRepo;

    public VideojuegoServices(VideojuegoRepo videojuegoRepo) {
        this.videojuegoRepo = videojuegoRepo;
    }


    public Videojuego crearVideojuego( RequestVideojuego payload) {
        Videojuego videojuegoNuevo = new Videojuego();

        videojuegoNuevo.setNombre(payload.getNombre());
        videojuegoNuevo.setPlataforma(payload.getPlataforma());
        videojuegoNuevo.setDisponible(true);

        return videojuegoRepo.save(videojuegoNuevo);

    }

    public List<Videojuego> videojuegosTodos() {
        return videojuegoRepo.findAll();
    }
}
