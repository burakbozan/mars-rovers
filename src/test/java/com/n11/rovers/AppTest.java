package com.n11.rovers;

import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Plateau;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testCoordinates()
    {
        Coordinates coords = new Coordinates(5, 5);
        assertEquals(5, coords.getX());
        assertEquals(5, coords.getY());
    }

    public void testPlateau()
    {
        Coordinates coords = new Coordinates(5, 5);
        Plateau plateau = new Plateau(coords);

        assertEquals(5, plateau.getMaxCoordinates().getX());
        assertEquals(5, plateau.getMaxCoordinates().getY());
    }
}
