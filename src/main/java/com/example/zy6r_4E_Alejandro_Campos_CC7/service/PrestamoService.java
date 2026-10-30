package com.example.zy6r_4E_Alejandro_Campos_CC7.service;

import com.example.zy6r_4E_Alejandro_Campos_CC7.exceptions.ReglaDeNegocio;
import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Estados;
import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Prestamo;
import com.example.zy6r_4E_Alejandro_Campos_CC7.model.Videojuego;
import com.example.zy6r_4E_Alejandro_Campos_CC7.model.dto.request.RequestPrestamo;
import com.example.zy6r_4E_Alejandro_Campos_CC7.repositories.PrestamoRepo;
import com.example.zy6r_4E_Alejandro_Campos_CC7.repositories.VideojuegoRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService {

    private final PrestamoRepo prestamoRepo;

    private final VideojuegoRepo videojuegoRepo;

    public PrestamoService(PrestamoRepo prestamoRepo, VideojuegoRepo videojuegoRepo) {
        this.prestamoRepo = prestamoRepo;
        this.videojuegoRepo = videojuegoRepo;
    }


    @Transactional
    public Prestamo crearPrestamo( RequestPrestamo payload) {
        Videojuego videojuego = videojuegoRepo.findById(payload.getIdVideojuego()).orElseThrow(()-> new RuntimeException("id no encontrado"));

        if(!videojuego.isDisponible()){
            throw new RuntimeException("Videojuego no disponible");
        }

        videojuego.setDisponible(false);

        Prestamo prestamo = new Prestamo();

        prestamo.setNombreSolicitante(payload.getSolicitante());
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.setFechaDevolucion(null);
        prestamo.setVideojuego(videojuego);
        prestamo.setEstados(Estados.ACTIVO);

        videojuegoRepo.save(videojuego);

        return prestamoRepo.save(prestamo);
    }
    @Transactional
    public Prestamo cancelarPrestamos(Long id) {
        Prestamo prestamo = prestamoRepo.findById(id).orElseThrow(()-> new RuntimeException("id no encontrado"));

        if(!(prestamo.getEstados()==Estados.ACTIVO)){
            throw new ReglaDeNegocio("Prestamos no esta activo");
        }

        prestamo.setEstados(Estados.CANCELADO);

        Videojuego videojuego = prestamo.getVideojuego();

        videojuego.setDisponible(true);

        videojuegoRepo.save(videojuego);
        return prestamoRepo.save(prestamo);
    }

    @Transactional
    public List<Prestamo> cancelarTodos() {
        List<Prestamo> prestamos = prestamoRepo.findAll();
        List<Prestamo> cancelados = new ArrayList<>();
        for(Prestamo p:prestamos){
            if(p.getEstados()==Estados.ACTIVO){
                p.setEstados(Estados.CANCELADO);
                Videojuego videojuego = p.getVideojuego();
                videojuego.setDisponible(true);
                videojuegoRepo.save(videojuego);
                prestamoRepo.save(p);
                cancelados.add(p);
            }
        }
        return cancelados;
    }
}
