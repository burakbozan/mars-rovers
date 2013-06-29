package com.n11.rovers;

import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Plateau;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PlateauTest extends TestCase
{

    public PlateauTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( PlateauTest.class );
    }

    public void testPlateau()
    {
        Coordinates coords = new Coordinates(5, 5);
        Plateau plateau = new Plateau(coords);

        assertEquals(5, plateau.getMaxCoordinates().getX());
        assertEquals(5, plateau.getMaxCoordinates().getY());
    }
}
