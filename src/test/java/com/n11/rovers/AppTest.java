package com.n11.rovers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Direction;
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

    public void testCoordinates()
    {
        Coordinates coords = new Coordinates(5, 5);
        assertEquals(5, coords.getX());
        assertEquals(5, coords.getY());
    }

    public void testCoordinatesGoOn()
    {
        Coordinates coords = new Coordinates(5, 5);
        assertEquals(new Coordinates(4, 5), coords.goOn(Direction.WEST));
        assertEquals(new Coordinates(5, 5), coords.goOn(Direction.EAST));
        assertEquals(new Coordinates(5, 4), coords.goOn(Direction.SOUTH));
        assertEquals(new Coordinates(5, 5), coords.goOn(Direction.NORTH));
    }
    
    public void testCoordinatesSum() throws SecurityException, NoSuchMethodException, 
        IllegalArgumentException, IllegalAccessException, InvocationTargetException
    {
        Coordinates coords1 = new Coordinates(1, 0);
        Coordinates coords2 = new Coordinates(1, 1);
        
        Method method = Coordinates.class.getDeclaredMethod("sum", Coordinates.class);
        method.setAccessible(true);
        Coordinates sum = (Coordinates) method.invoke(coords1, coords2);
        assertEquals(new Coordinates(2, 1), sum);
    }

    public void testPlateau()
    {
        Coordinates coords = new Coordinates(5, 5);
        Plateau plateau = new Plateau(coords);

        assertEquals(5, plateau.getMaxCoordinates().getX());
        assertEquals(5, plateau.getMaxCoordinates().getY());
    }
    
    public void testDirectionOnLeft()
    {
        assertEquals(Direction.NORTH, Direction.EAST.onLeft());
        assertEquals(Direction.WEST, Direction.NORTH.onLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.onLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.onLeft());
    }

    public void testDirectionOnForward()
    {
        assertEquals(new Coordinates(1, 0), Direction.EAST.onForward());
        assertEquals(new Coordinates(-1, 0), Direction.WEST.onForward());
        assertEquals(new Coordinates(0, -1), Direction.SOUTH.onForward());
        assertEquals(new Coordinates(0, 1), Direction.NORTH.onForward());
    }
}
