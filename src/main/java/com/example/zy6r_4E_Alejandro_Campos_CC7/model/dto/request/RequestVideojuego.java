package com.example.zy6r_4E_Alejandro_Campos_CC7.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestVideojuego {

    @NotBlank
    @Size(min = 1,max= 50)
    String nombre;

    @NotBlank
    @Size(min = 1,max= 50)
    String plataforma;

}
