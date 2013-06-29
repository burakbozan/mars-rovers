package com.n11.rovers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.n11.rovers.models.Coordinates;
import com.n11.rovers.models.Direction;

import junit.framework.TestCase;

public class CoordinatesTest extends TestCase
{
    public CoordinatesTest( String testName )
    {
        super( testName );
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
}
