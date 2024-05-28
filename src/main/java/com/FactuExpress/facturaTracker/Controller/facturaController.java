package com.FactuExpress.facturaTracker.Controller;

import com.FactuExpress.facturaTracker.Models.Factura;
import com.FactuExpress.facturaTracker.Models.FacturaDto;
import com.FactuExpress.facturaTracker.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping()
public class facturaController {
	@Autowired
	FacturaService facturaService;


	@GetMapping()
	public String newFactura(@RequestBody FacturaDto factura) {
		return facturaService.saveFactura(factura);
	}
}
