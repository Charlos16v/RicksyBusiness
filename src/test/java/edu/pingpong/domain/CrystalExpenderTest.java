package edu.pingpong.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CrystalExpenderTest {

    CrystalExpender crystalExpender = null;
    CreditCard card = null;

    @Before
    public void setupCrystalExpender() {
        crystalExpender = new CrystalExpender(4, 50);
        card = new CreditCard("Master", "8888");
    }

    @Test
    public void constructorTest() {
        assertNotNull(crystalExpender);
    }

    @Test
    public void dispatchTest() {
        crystalExpender.dispatch(card);
        assertEquals(2950, card.credit(), 0);
    }
}

