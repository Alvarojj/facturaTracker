package com.FactuExpress.facturaTracker.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Notification {
    private String receptor;
    private String sender;
}
