package com.example.zy6r_4E_Alejandro_Campos_CC7.controller;

import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Prestamo;
import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Videojuego;
import com.example.zy6r_4E_Alejandro_Campos_CC7.model.dto.request.RequestPrestamo;
import com.example.zy6r_4E_Alejandro_Campos_CC7.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public ResponseEntity<Prestamo> crearPrestamo(@Valid @RequestBody RequestPrestamo payload){
        return ResponseEntity.status(201).body( prestamoService.crearPrestamo(payload) );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Prestamo> cancelarPrestamo(@PathVariable Long id){
        return ResponseEntity.ok( prestamoService.cancelarPrestamos(id) );
    }

    @PatchMapping
    public ResponseEntity<List<Prestamo>> cancelarTodos(){
        return ResponseEntity.ok( prestamoService.cancelarTodos() );
    }

}
