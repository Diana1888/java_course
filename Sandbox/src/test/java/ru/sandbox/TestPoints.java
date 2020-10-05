package ru.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPoints {
    @Test
    public void TestDist(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Assert.assertEquals(p1.distance(p2), 5);
    }
}
