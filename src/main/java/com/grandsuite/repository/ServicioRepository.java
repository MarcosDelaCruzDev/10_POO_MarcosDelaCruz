package com.grandsuite.repository;

import com.grandsuite.model.Servicio;
import java.util.ArrayList;
import java.util.List;

public class ServicioRepository {
    private final List<Servicio> servicios = new ArrayList<>();

    public ServicioRepository() {
        servicios.add(new Servicio(1, "Wi-Fi Gratis", "wifi"));
        servicios.add(new Servicio(2, "Desayuno Buffet", "desayuno"));
        servicios.add(new Servicio(3, "Piscina & Spa", "piscina"));
        servicios.add(new Servicio(4, "Estacionamiento", "estacionamiento"));
    }

    public List<Servicio> obtenerTodos() {
        return new ArrayList<>(servicios);
    }
}
