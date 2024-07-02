package com.FactuExpress.facturaTracker.Controller;

import com.FactuExpress.facturaTracker.Models.Factura;
import com.FactuExpress.facturaTracker.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("Factura")
public class facturaController {
	@Autowired
	FacturaService facturaService;


	@PostMapping("save")
	public String newFactura(@RequestBody Factura factura) {
		return facturaService.saveFactura(factura);
	}
}
