package edu.eci.arsw.blueprints.filtro.impl;

import edu.eci.arsw.blueprints.filtro.*;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component("submuestrado")
public class filtrossubmuestrando implements filtro {
    @Override
    public Blueprint filtroblueprint(Blueprint blueprint) {
        List<Point> list = blueprint.getPoints();
        List<Point> update = new ArrayList<Point>();

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                update.add(list.get(i));
            }
        }

        blueprint.updatePoint(update);

        return blueprint;
    }

    @Override
    public Set<Blueprint> multiFilter(Set<Blueprint> blueprints) {
        for (Blueprint bl : blueprints) {
            filtroblueprint(bl);
        }
        return blueprints;
    }
}