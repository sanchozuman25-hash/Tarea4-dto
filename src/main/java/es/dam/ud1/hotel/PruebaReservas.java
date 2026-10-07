package es.dam.ud1.hotel;

public class PruebaReservas {

    public static void main(String[] args) {
        Cliente cliente = new Cliente(1L, "Laura", "Gómez Ruiz", "laura@mail.com", "600111222");
        Habitacion doble = new Habitacion(1L, "204", "Doble", 85.5, 2);
        Habitacion sinPrecio = new Habitacion(2L, "305", "Suite", null, 3);

        Reserva completa = new Reserva(1L, "RES-001", 3, cliente, doble);
        Reserva sinCliente = new Reserva(2L, "RES-002", 2, null, doble);
        Reserva sinHabitacion = new Reserva(3L, "RES-003", 4, cliente, null);
        Reserva sinNoches = new Reserva(4L, "RES-004", null, cliente, doble);
        Reserva habSinPrecio = new Reserva(5L, "RES-005", 2, cliente, sinPrecio);
        Reserva vacia = new Reserva();

        System.out.println("Completa:         " + ReservaDTO.from(completa));
        System.out.println("Sin cliente:      " + ReservaDTO.from(sinCliente));
        System.out.println("Sin habitación:   " + ReservaDTO.from(sinHabitacion));
        System.out.println("Sin noches:       " + ReservaDTO.from(sinNoches));
        System.out.println("Hab. sin precio:  " + ReservaDTO.from(habSinPrecio));
        System.out.println("Reserva vacía:    " + ReservaDTO.from(vacia));
        System.out.println("Reserva null:     " + ReservaDTO.from(null));
    }
}
