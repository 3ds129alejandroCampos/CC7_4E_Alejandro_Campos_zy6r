package com.example.zy6r_4E_Alejandro_Campos_CC7.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
	private String nombreSolicitante;
    @Column
	private LocalDate fechaPrestamo;
    @Column
	private LocalDate fechaDevolucion;

    @Enumerated(EnumType.STRING)
	private Estados estados;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("prestamoLista")
	private Videojuego videojuego;



}
