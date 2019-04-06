package ltd.model.sakila.layers.movieDB.view;

import javax.persistence.Column;


public class ActorView {

    @Column(name = "ACTOR_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


}
