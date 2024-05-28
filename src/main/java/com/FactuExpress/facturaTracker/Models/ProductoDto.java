package com.FactuExpress.facturaTracker.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private String nombre;
    private int cantidad;
    private double total;
    private double totalIva;
}
