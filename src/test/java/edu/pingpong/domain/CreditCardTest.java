package edu.pingpong.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CreditCardTest {

    CreditCard creditCard = null;


    @Before
    public void setupCard() {
        creditCard = new CreditCard("Master", "123456789");
    }

    @Test
    public void constructorTest() {
        assertNotNull(creditCard);
    }

}
