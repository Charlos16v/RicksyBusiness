package edu.pingpong.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UfosParkTest {


    UfosPark ufosPark = null;
    String[] ovnis = { "unx", "dox", "trex" };


    @Before
    public void setupUfosPark() {
        ufosPark = new UfosPark();
        for (String ovni : ovnis) {
            ufosPark.add(ovni);
        }
    }


    @Test
    public void constructorTest() {
        assertNotNull(ufosPark);
    }


    /**
     * Testea el metodo añadir ovni 
     * a la flota de ufos
     */
    @Test
    public void addUfoTest() {
        assertEquals("[trex, dox, unx]", ufosPark.toString());
    }

    /**
     * Testea el metodo reservar ovni 
     * y cargar el pago en la tarjeta 
     * de crédito.
     * El crédito de la tarjeta varía.
     */
    @Test
    public void dispatchTest() {
    }

    /**
     * Testea que no se pueda reservar un ovni 
     * si no hay crédito suficiente en la tarjeta.
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchNoCreditTest() {
    }

    /**
     * Testea que no se pueda reservar un ovni 
     * si ya existe un ovni reservado para esa tarjeta.
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchUfoAlreadyReservedTest() {
    }

    /**
     * Testea que no se pueda reservar un ovni 
     * si no existe ninguno disponible (sin reservar).
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchNoUfoAvaliableTest() {
    }

    /**
     * Devuelve el UFO reservado para la tarjeta.
     */
    @Test
    public void getUfoOfTest() {
    }
}
