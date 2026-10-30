package com.example.zy6r_4E_Alejandro_Campos_CC7.controller;


import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Videojuego;
import com.example.zy6r_4E_Alejandro_Campos_CC7.model.dto.request.RequestVideojuego;
import com.example.zy6r_4E_Alejandro_Campos_CC7.service.VideojuegoServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/VG")
public class VideojuegoController {

    private final VideojuegoServices videojuegoServices;

    public VideojuegoController(VideojuegoServices videojuegoServices) {
        this.videojuegoServices = videojuegoServices;
    }

    @PostMapping
    public ResponseEntity<Videojuego> crearVG(@Valid @RequestBody RequestVideojuego payload){
        return ResponseEntity.status(201).body( videojuegoServices.crearVideojuego(payload) );
    }

    @GetMapping
    public ResponseEntity<List<Videojuego>> videoJuegoDismponible(){
        return ResponseEntity.ok( videojuegoServices.videojuegosTodos() );
    }
}
