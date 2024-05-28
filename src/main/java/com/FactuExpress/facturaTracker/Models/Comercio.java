package com.FactuExpress.facturaTracker.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String razon;
    private int nit;
    private String telefono;
    private String direccion;
    private String municipio;
    private String departamento;
    @OneToMany(mappedBy = "comercio")
    List<Factura> facturas;
}
