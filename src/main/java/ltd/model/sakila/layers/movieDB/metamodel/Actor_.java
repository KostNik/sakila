package ltd.model.sakila.layers.movieDB.metamodel;

import ltd.model.sakila.layers.movieDB.Actor;
import org.joda.time.DateTime;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Actor.class)
public class Actor_ {

    public static volatile SingularAttribute<Actor, Long>     id;
    public static volatile SingularAttribute<Actor, String>   firstName;
    public static volatile SingularAttribute<Actor, String>   lastName;
    public static volatile SingularAttribute<Actor, DateTime> lastUpdate;

}
