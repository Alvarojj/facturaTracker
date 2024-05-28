package com.FactuExpress.facturaTracker.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String apellido;
    private String cedula;
    private String clave;
    private String correo;
    private String departamento;
    private String direccion;
    private Date fechaNacimiento;
    private String municipio;
    private String nombre;
    private String telefono;
    @OneToMany(mappedBy = "usuario")
    List<Factura> facturas;
}
