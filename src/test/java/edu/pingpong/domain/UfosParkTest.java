package edu.pingpong.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UfosParkTest {


    UfosPark ufosPark = null;
    String[] ovnis = {"unx", "dox", "trex"};


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
        CreditCard firstCard = new CreditCard("Master", "0000");
        CreditCard secondCard = new CreditCard("Aguila", "8888");

        ufosPark.dispatch(firstCard);
        ufosPark.dispatch(secondCard);

        assertEquals("trex", ufosPark.getUfoOf(firstCard.number()));
        assertEquals("dox", ufosPark.getUfoOf(secondCard.number()));
    }

    /**
     * Testea que no se pueda reservar un ovni
     * si no hay crédito suficiente en la tarjeta.
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchNoCreditTest() {
        CreditCard noCreditCard = new CreditCard("NoMoney", "6969");

        noCreditCard.pay(3000);

        ufosPark.dispatch(noCreditCard);

        assertNull(ufosPark.getUfoOf(noCreditCard.number()));
    }

    /**
     * Testea que no se pueda reservar un ovni
     * si ya existe un ovni reservado para esa tarjeta.
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchUfoAlreadyReservedTest() {
        CreditCard master = new CreditCard("master", "0000");

        ufosPark.dispatch(master);
        assertEquals("trex", ufosPark.getUfoOf(master.number()));

        ufosPark.dispatch(master);
        assertEquals("trex", ufosPark.getUfoOf(master.number()));
    }

    /**
     * Testea que no se pueda reservar un ovni
     * si no existe ninguno disponible (sin reservar).
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchNoUfoAvaliableTest() {
        CreditCard firstCard = new CreditCard("Master", "0000");
        CreditCard secondCard = new CreditCard("Aguila", "8888");
        CreditCard thirdCard = new CreditCard("Observador", "7777");
        CreditCard fourthCard = new CreditCard("Fido", "2222");

        ufosPark.dispatch(firstCard);
        ufosPark.dispatch(secondCard);
        ufosPark.dispatch(thirdCard);
        ufosPark.dispatch(fourthCard); // Only 3 ufos on the fleet, its going to be null.

        assertNull(ufosPark.getUfoOf(fourthCard.number()));
    }

    /**
     * Devuelve el UFO reservado para la tarjeta.
     */
    @Test
    public void getUfoOfTest() {
        CreditCard master = new CreditCard("master", "0000");

        ufosPark.dispatch(master);
        assertEquals("trex", ufosPark.getUfoOf(master.number()));
    }
}
