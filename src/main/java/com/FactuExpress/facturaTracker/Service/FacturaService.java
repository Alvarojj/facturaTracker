package com.FactuExpress.facturaTracker.Service;

import com.FactuExpress.facturaTracker.Component.Publisher;
import com.FactuExpress.facturaTracker.Models.*;
import com.FactuExpress.facturaTracker.Repositories.ComercioRepository;
import com.FactuExpress.facturaTracker.Repositories.FacturaRepository;
import com.FactuExpress.facturaTracker.Repositories.ProductoRepository;
import com.FactuExpress.facturaTracker.Repositories.UsuarioRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ComercioRepository comercioRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    Publisher publisher;

    @Transactional
    public String saveFactura(FacturaDto factura) {
        Usuario usuario = getUsuario(factura.getIdUser());
        Comercio comercio = getComercio(factura.getNit());
        if (comercio != null && usuario != null){
            Factura newFactura = translateFactura(factura);
            newFactura.setUsuario(usuario);
            newFactura.setComercio(comercio);
            facturaRepository.save(newFactura);
            List<Producto> productos = getProductos(factura, newFactura);
            productoRepository.saveAll(productos);
            sendQueue(usuario.getCorreo(), comercio.getRazon());
            return "Factura enviada correctamente";
        }
        return "Comercio no encontrado";
    }

    private void sendQueue(String receptor, String sender){
        Gson gson = new Gson();
        String json = gson.toJson(new Notification(receptor, sender));
        publisher.send(json);
    }
    private Factura translateFactura(FacturaDto factura){
        Factura newFactura = new Factura();
        newFactura.setFecha(factura.getFecha());
        newFactura.setIva(factura.getIva());
        newFactura.setSubtotal(factura.getSubtotal());
        newFactura.setTotal(factura.getTotal());
        newFactura.setNumerofact(factura.getNumeroFact());

        return newFactura;
    }
    private List<Producto> getProductos(FacturaDto factura, Factura newFactura) {
        List<Producto> productos = new ArrayList<>();
        for (int i = 0; i < factura.getProducto().size(); i++){
            Producto producto = new Producto();
            producto.setNombre(factura.getProducto().get(i).getNombre());
            producto.setCantidad(factura.getProducto().get(i).getCantidad());
            producto.setTotal(factura.getProducto().get(i).getTotal());
            producto.setTotalIva(factura.getProducto().get(i).getTotalIva());
            producto.setFactura(newFactura);
            productos.add(producto);
        }
        return productos;
    }

    public Usuario getUsuario(String id){
        return usuarioRepository.findByCedula(id);
    }

    public Comercio getComercio(int nit) {
        return comercioRepository.findByNit(nit);
    }


}
