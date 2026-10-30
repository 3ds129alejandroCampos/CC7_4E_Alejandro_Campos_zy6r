package com.example.zy6r_4E_Alejandro_Campos_CC7.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestPrestamo {

    @Min(1)
    Long idVideojuego;

    @NotBlank
    String solicitante;

}
