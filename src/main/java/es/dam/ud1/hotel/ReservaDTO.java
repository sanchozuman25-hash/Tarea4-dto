package es.dam.ud1.hotel;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record ReservaDTO(String codigo, String cliente, String habitacion,
                         Integer numeroNoches, Double precioTotal) {

    private static final String SIN_CLIENTE = "Sin cliente";
    private static final String SIN_HABITACION = "Sin habitación";

    /**
     * Transforma una Reserva en ReservaDTO de forma segura.
     * - reserva null -> null
     * - sin cliente / habitación -> texto por defecto
     * - noches o precio por noche no informados -> precioTotal = null
     */
    public static ReservaDTO from(Reserva reserva) {
        if (reserva == null) {
            return null;
        }
        Habitacion hab = reserva.getHabitacion();
        return new ReservaDTO(
                reserva.getCodigo(),
                descripcionCliente(reserva.getCliente()),
                descripcionHabitacion(hab),
                reserva.getNumeroNoches(),
                calcularPrecioTotal(reserva.getNumeroNoches(), hab));
    }

    private static String descripcionCliente(Cliente cliente) {
        if (cliente == null) {
            return SIN_CLIENTE;
        }
        String texto = unir(" ", cliente.getNombre(), cliente.getApellidos());
        return texto.isEmpty() ? SIN_CLIENTE : texto;
    }

    private static String descripcionHabitacion(Habitacion hab) {
        if (hab == null) {
            return SIN_HABITACION;
        }
        String texto = unir(" - ", hab.getNumero(), hab.getTipo());
        return texto.isEmpty() ? SIN_HABITACION : texto;
    }

    private static Double calcularPrecioTotal(Integer noches, Habitacion hab) {
        if (noches == null || hab == null || hab.getPrecioNoche() == null) {
            return null;
        }
        return noches * hab.getPrecioNoche();
    }

    private static String unir(String separador, String... partes) {
        return Stream.of(partes)
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(separador));
    }
}
