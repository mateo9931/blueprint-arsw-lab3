package edu.eci.arsw.blueprints.filtro;

import edu.eci.arsw.blueprints.model.Blueprint;

import java.util.Set;

public interface filtro {

    public Blueprint filtroblueprint(Blueprint blueprint);


    public Set<Blueprint> multiFilter(Set<Blueprint> blueprints);
}
