package ltd.repository.actor;

import ltd.model.sakila.layers.movieDB.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActorDAO {

    Actor findById(Long id);

    Long getTotalAmount();

    List<Actor> findFromTo(long from, long to);

    List<Actor> findAll();

    Page<Actor> findAll(Pageable pageable);

    List<Actor> findByFirstName(String firstName);

    List<Actor> findByLastName(String lastName);

    List<Actor> findByFirstAndLastName(String firstName, String lastName);

    Actor save(Actor actor);

    void delete(Actor actor);

    void deleteById(Long id);

    void update(Long id, Actor actor);

}
