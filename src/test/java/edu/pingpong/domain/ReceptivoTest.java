package edu.pingpong.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReceptivoTest {


    private Receptivo receptivo = null;
    private UfosParkTest ufosPark = null;
    private CrystalExpender crystalExpender = null;

    @Before
    public void setupReceptivo() {
        ufosPark = new UfosParkTest();
        ufosPark.setupUfosPark();

        crystalExpender = new CrystalExpender(10, 50);

        receptivo = new Receptivo();
        receptivo.registra(ufosPark.ufosPark);
        receptivo.registra(crystalExpender);
    }

    @Test
    public void dispatchTest() {
        CreditCard card = new CreditCard("Maquina", "8888");

        receptivo.dispatch(card);

        assertEquals(2450, card.credit(), 0);
        assertEquals(9, crystalExpender.stock());
        assertTrue(ufosPark.ufosPark.containsCard(card.number()));
    }


}
