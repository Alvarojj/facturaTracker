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
    @Column(name = "numero_factura")
    private int numerofact;
    private Date fecha;
    private double iva;
    private double subtotal;
    private double total;
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Producto> producto;
    @ManyToOne()
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @ManyToOne()
    @JoinColumn(name = "idcomercio")
    private Comercio comercio;
}
