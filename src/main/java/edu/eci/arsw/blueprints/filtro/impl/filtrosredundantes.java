package edu.eci.arsw.blueprints.filtro.impl;

import edu.eci.arsw.blueprints.filtro.filtro;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component("redundante")
public class filtrosredundantes implements filtro {
    @Override
    public Blueprint filtroblueprint(Blueprint blueprint) {
        List<Point> listPoint = blueprint.getPoints();
        List<Point> update = new ArrayList<Point>();
        update.add(listPoint.get(0));
        for (int i = 1; i < listPoint.size(); i++) {
            Point point = listPoint.get(i - 1);
            if (!(point.getX() == listPoint.get(i).getX() && point.getY() == listPoint.get(i).getY())) {
                update.add(listPoint.get(i));
            }
        }

        blueprint.updatePoint(update);
        return blueprint;
    }

    @Override
    public Set<Blueprint> multiFilter(Set<Blueprint> blueprints) {
        for (Blueprint blueprint : blueprints) {
            filtroblueprint(blueprint);
        }
        return blueprints;
    }

}