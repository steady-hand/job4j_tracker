package ru.job4j.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void distance() {
        Point x = new Point(0, 4);
        Point y = new Point(0, 0);
        double rsl = x.distance(y);
        double expected = 4;
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    void distance3d()  {
        Point x = new Point(0, 0, 5);
        Point y = new Point(0, 0, 0);
        double rsl = x.distance3d(y);
        double expected = 5;
        Assert.assertEquals(expected, rsl, 0.01);
    }
}