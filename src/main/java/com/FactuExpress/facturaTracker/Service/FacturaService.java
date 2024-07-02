package com.FactuExpress.facturaTracker.Service;

import com.FactuExpress.facturaTracker.Component.Publisher;
import com.FactuExpress.facturaTracker.Models.*;
import com.FactuExpress.facturaTracker.Repositories.ComercioRepository;
import com.FactuExpress.facturaTracker.Repositories.FacturaRepository;
import com.FactuExpress.facturaTracker.Repositories.UsuarioRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    Publisher publisher;

    @Transactional
    public String saveFactura(Factura factura) {
        Usuario usuario = getUsuario(factura.getUsuario().getId());
        Comercio comercio = getComercio(factura.getComercio().getId());
        if (comercio != null && usuario != null){
            factura.setUsuario(usuario);
            factura.setComercio(comercio);
            factura.setFecha(new Date());
            facturaRepository.save(factura);
            //sendQueue(usuario.getCorreo(), comercio.getRazon());
            return "Factura enviada correctamente";
        }
        return "Comercio no encontrado";
    }

    private void sendQueue(String receptor, String sender){
        Gson gson = new Gson();
        String json = gson.toJson(new Notification(receptor, sender));
        publisher.send(json);
    }



    public Usuario getUsuario(int id){
        return usuarioRepository.findById(id);
    }

    public Comercio getComercio(int id) {
        return comercioRepository.findById(id);
    }


}
