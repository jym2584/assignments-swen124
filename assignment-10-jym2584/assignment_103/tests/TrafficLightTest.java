package assignment_103.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class TrafficLightTest {
    @Test
    public void gettersTest() {
        Object lock = new Object();
        TrafficLight lightOne = new TrafficLight(LightDirection.NORTH_SOUTH, lock);


        assertEquals(lightOne.getColor(), TrafficLight.Color.RED);
        assertEquals(lightOne.getDirection(), LightDirection.NORTH_SOUTH);
        assertEquals(lightOne.getLock(), lock);

        
    }
}
