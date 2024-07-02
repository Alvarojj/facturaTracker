package com.FactuExpress.facturaTracker.Models;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    private double total;
    private String descripcion;
    @ManyToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne()
    @JoinColumn(name = "id_comercio")
    private Comercio comercio;
}
