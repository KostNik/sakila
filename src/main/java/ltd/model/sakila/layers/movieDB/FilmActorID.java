package ltd.model.sakila.layers.movieDB;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Embeddable
public class FilmActorID implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5926190546661553957L;

    @OneToOne
    @JoinColumn(name = "FILM_ID")
    private Film  film;

    @OneToOne
    @JoinColumn(name = "ACTOR_ID")
    private Actor actor;

}
