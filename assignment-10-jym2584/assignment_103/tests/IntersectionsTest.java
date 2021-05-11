package assignment_103.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import assignment_103.Intersection;
import assignment_103.TrafficLight;
import assignment_103.TrafficLight.LightDirection;

/**
 * All of the helper methods that I mad efor intersection are private, so I'm unsure how to test for that
 * Hope I could get some feedback for this, if I just make them into public and do the testing anyway
 * 
 * Hope I can also get some feedback if testing for getters are necessary
 */
@Testable
public class IntersectionsTest {
    @Test
    public void gettersTest() {
        Object lock = new Object();
        TrafficLight lightOne = new TrafficLight(LightDirection.NORTH_SOUTH, lock);
        TrafficLight lightTwo = new TrafficLight(LightDirection.EAST_WEST, lock);

        Intersection intersection = new Intersection(lightOne, lightTwo);

        assertEquals(lightOne, intersection.getNorthSouth());
        assertEquals(lightTwo, intersection.getEastWest());

        
    }

    /**
     * Not sure how to test this since the method is private
     */
    @Test
    public void lightisGreenTest() {
        Object lock = new Object();
        TrafficLight lightOne = new TrafficLight(LightDirection.NORTH_SOUTH, lock);
        TrafficLight lightTwo = new TrafficLight(LightDirection.EAST_WEST, lock);

        Intersection intersection = new Intersection(lightOne, lightTwo);

        assertTrue(intersection.lightIsGreen(lightOne));
    }
}
