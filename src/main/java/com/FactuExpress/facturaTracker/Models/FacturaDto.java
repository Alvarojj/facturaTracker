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
public class FacturaDto {
    private int nit;
    private String idUser;
    private int numeroFact;
    private Date fecha;
    private double iva;
    private double subtotal;
    private double total;
    private List<ProductoDto> producto;
}
