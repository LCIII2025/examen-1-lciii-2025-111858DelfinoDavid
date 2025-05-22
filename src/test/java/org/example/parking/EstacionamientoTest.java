package org.example.parking;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    private Estacionamiento estacionamiento;
    private Vehiculo vehiculo;
    private Cliente cliente;


    @Before
    public void setup(){
        estacionamiento=new Estacionamiento();
        vehiculo=new Vehiculo("AAA","Chevrolet Meriva", Vehiculo.Tipo.AUTO);
        cliente=new Cliente("111","David");
        estacionamiento.ingresarVehiculo(cliente.getDni(),cliente.getNombre(),vehiculo);
    }

    @Test
    public void testRetirarVehiculo() throws Exception {
        //DONE test
        setup();

        Ticket ticket=estacionamiento.retirarVehiculo("AAA");

        assertEquals(ticket.getVehiculo().getPatente(),vehiculo.getPatente());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // DONE test
        Ticket ticket=estacionamiento.retirarVehiculo("AAA");
        ticket.marcarSalida();

        double precio=ticket.calcularPrecio();

        assertEquals(300.0,precio,100.0);


    }

}