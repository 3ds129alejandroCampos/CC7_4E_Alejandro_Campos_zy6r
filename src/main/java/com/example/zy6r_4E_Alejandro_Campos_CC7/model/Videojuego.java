package com.example.zy6r_4E_Alejandro_Campos_CC7.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String plataforma;

    @Column
    private boolean disponible;


    @OneToMany(mappedBy = "videojuego")
    @JsonIgnore
    private List<Prestamo> prestamoLista;


}
