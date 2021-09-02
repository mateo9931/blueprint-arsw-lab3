package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.filtro.*;
import edu.eci.arsw.blueprints.filtro.impl.filtrossubmuestrando;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubmuestradoTest {
    private filtro filtro;
    private List<Blueprint> list;

    @Before
    public void setVariable() {
        filtro = new filtrossubmuestrando();

        Point[] pts0 = new Point[]{new Point(40, 40), new Point(15, 15), new Point(15, 15)};
        Blueprint bp0 = new Blueprint("john", "paint1", pts0);

        Point[] pts1 = new Point[]{new Point(40, 40), new Point(40, 40), new Point(40, 40), new Point(15, 15)};
        Blueprint bp1 = new Blueprint("Mateo", "paint2", pts1);


        Point[] pts2 = new Point[]{new Point(40, 40), new Point(15, 15)};
        Blueprint bp2 = new Blueprint("brayan", "paint3", pts2);

        list = new ArrayList<Blueprint>();
        list.add(bp0);
        list.add(bp1);
        list.add(bp2);

    }


    @Test
    public void uniqueFilterTest() {
        Blueprint bl = list.get(0);
        List<Point> list1 = bl.getPoints();
        Blueprint bl2 = filtro.filtroblueprint(bl);
        List<Point> list2 = bl2.getPoints();
        Assert.assertTrue(list1.size() != list2.size());
    }

    @Test
    public void multiFilterTest() {
        List<Point> b1 = list.get(0).getPoints();
        List<Point> b2 = list.get(1).getPoints();
        List<Point> b3 = list.get(2).getPoints();
        Set<Blueprint> setB = new HashSet<Blueprint>(list);
        Set<Blueprint> setResponse = filtro.multiFilter(setB);
        List<Blueprint> listb = new ArrayList<>(setResponse);
        List<Point> r1 = listb.get(0).getPoints();
        List<Point> r2 = listb.get(1).getPoints();
        List<Point> r3 = listb.get(2).getPoints();
        Assert.assertTrue(b1.size() != r1.size());
        Assert.assertTrue(b2.size() != r2.size());
        Assert.assertTrue(b3.size() != r3.size());
    }

}