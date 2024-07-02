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
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;
    @Column(name = "ahorro_papel")
    private int ahorroPapel;
    private String apellido;
    private String cedula;
    private String correo;
    private String nombre;
    @OneToMany(mappedBy = "usuario")
    List<Factura> facturas;
}
