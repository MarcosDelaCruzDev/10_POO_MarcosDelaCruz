package com.grandsuite.repository;

import com.grandsuite.model.Habitacion;
import java.util.ArrayList;
import java.util.List;

public class HabitacionRepository {
    private final List<Habitacion> habitaciones = new ArrayList<>();

    public HabitacionRepository() {
        habitaciones.add(new Habitacion(
                1,
                "Habitacion Estandar",
                "Habitacion comoda con todas las amenidades basicas",
                90.00,
                "/images/habitacion-estandar.png",
                "Estandar"
        ));
        habitaciones.add(new Habitacion(
                2,
                "Habitacion Presidencial",
                "Suite de lujo con vista panoramica y servicio premium",
                150.00,
                "/images/habitacion-presidencial.png",
                "Presidencial"
        ));
    }

    public List<Habitacion> obtenerTodas() {
        return new ArrayList<>(habitaciones);
    }

    public Habitacion obtenerPorId(int id) {
        return habitaciones.stream()
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
