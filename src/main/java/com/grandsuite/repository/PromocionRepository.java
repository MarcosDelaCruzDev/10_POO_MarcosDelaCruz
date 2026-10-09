package com.grandsuite.repository;

import com.grandsuite.model.Promocion;
import java.util.ArrayList;
import java.util.List;

public class PromocionRepository {
    private final List<Promocion> promociones = new ArrayList<>();

    public PromocionRepository() {
        promociones.add(new Promocion(
                1,
                "Ventas Flash de Temporada",
                "Solo por 48 horas: 30% Off en todo el hotel. Cupos limitados.",
                "30%"
        ));
        promociones.add(new Promocion(
                2,
                "Reservacion Prolongada",
                "Asegura tu viaje con 30 dias de anticipacion y llévate un 25% de descuento.",
                "25%"
        ));
        promociones.add(new Promocion(
                3,
                "Escapada de Fin de Semana",
                "Disfruta de un 20% de descuento en habitaciones matrimoniales de viernes a domingo.",
                "20%"
        ));
    }

    public List<Promocion> obtenerTodas() {
        return new ArrayList<>(promociones);
    }
}
