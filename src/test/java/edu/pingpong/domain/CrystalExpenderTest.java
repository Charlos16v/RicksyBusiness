package edu.pingpong.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CrystalExpenderTest {

    CrystalExpender crystalExpender = null;

    @Before
    public void setupCrystalExpender() {
        crystalExpender = new CrystalExpender(4, 50);
    }

    @Test
    public void constructorTest() {
        assertNotNull(crystalExpender);
    }
}
