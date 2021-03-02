package edu.pingpong.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RickMenuTest {


    RickMenu rickMenu = null;
    CreditCard card = null;

    @Before
    public void setupRickMenu() {
        rickMenu = new RickMenu(10, 10);
        card = new CreditCard("Master", "8888");
    }

    @Test
    public void constructorTest() {
        assertNotNull(rickMenu);
    }

    @Test
    public void dispatchTest() {
        rickMenu.dispatch(card);
        assertEquals(2990, card.credit(), 0);
    }
}
