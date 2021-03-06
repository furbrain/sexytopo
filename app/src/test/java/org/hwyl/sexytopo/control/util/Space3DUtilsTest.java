package org.hwyl.sexytopo.control.util;

import org.hwyl.sexytopo.model.graph.Coord3D;
import org.hwyl.sexytopo.model.survey.Leg;
import org.junit.Assert;
import org.junit.Test;


public class Space3DUtilsTest {

    @Test
    public void testTransform1MNorth() {
        Leg north1MLeg = new Leg(1, 0, 0);
        Coord3D result = Space3DUtils.toCartesian(Coord3D.ORIGIN, north1MLeg);
        Coord3D expected = new Coord3D(0, 1, 0);
        assertEquals(expected, result);
    }

    @Test
    public void testTransform1MEast() {
        Leg east1MLeg = new Leg(1, 90, 0);
        Coord3D result = Space3DUtils.toCartesian(Coord3D.ORIGIN, east1MLeg);
        Coord3D expected = new Coord3D(1, 0, 0);
        assertEquals(expected, result);
    }

    @Test
    public void testTransform1MUp() {
        Leg up1MLeg = new Leg(1, 0, 90);
        Coord3D result = Space3DUtils.toCartesian(Coord3D.ORIGIN, up1MLeg);
        Coord3D expected = new Coord3D(0, 0, 1);
        assertEquals(expected, result);
    }

    @Test
    public void testTransform1MDown() {
        Leg up1MLeg = new Leg(1, 0, -90);
        Coord3D result = Space3DUtils.toCartesian(Coord3D.ORIGIN, up1MLeg);
        Coord3D expected = new Coord3D(0, 0, -1);
        assertEquals(expected, result);
    }

    @Test
    public void testTransform2MNorth() {
        Leg north2MLeg = new Leg(2, 0, 0);
        Coord3D result = Space3DUtils.toCartesian(Coord3D.ORIGIN, north2MLeg);
        Coord3D expected = new Coord3D(0, 2, 0);
        assertEquals(expected, result);
    }

    @Test
    public void testTransform3N3E3S3W() {
        Leg n3 = new Leg(3, 0, 0);
        Coord3D result = Space3DUtils.toCartesian(Coord3D.ORIGIN, n3);
        Leg e3 = new Leg(3, 90, 0);
        result = Space3DUtils.toCartesian(result, e3);
        Leg s3 = new Leg(3, 180, 0);
        result = Space3DUtils.toCartesian(result, s3);
        Leg w3 = new Leg(3, 270, 0);
        result = Space3DUtils.toCartesian(result, w3);
        assertEquals(Coord3D.ORIGIN, result);
    }

    @Test
    public void testTransform10mNEUAndBack() {
        Leg northEastAndUp10M = new Leg(10, 45, 45);
        Coord3D result = Space3DUtils.toCartesian(Coord3D.ORIGIN, northEastAndUp10M);
        Leg reverse = new Leg(10, 225, -45);
        result = Space3DUtils.toCartesian(result, reverse);
        assertEquals(Coord3D.ORIGIN, result);
    }

    private void assertEquals(Coord3D zero, Coord3D one) {

        double x0 = zero.x;
        double y0 = zero.y;
        double z0 = zero.z;
        double x1 = one.x;
        double y1 = one.y;
        double z1 = one.z;

        double delta = 0.0001;
        Assert.assertEquals(x0, x1, delta);
        Assert.assertEquals(y0, y1, delta);
        Assert.assertEquals(z0, z1, delta);
    }
}