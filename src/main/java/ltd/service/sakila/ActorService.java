package ltd.service.sakila;

import ltd.model.sakila.layers.movieDB.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ActorService {

    Actor findById(Long id);

    List<Actor> findAll();

    Page<Actor> findAllByPage(Pageable pageable);

    List<Actor> findByFirstName(String firstName);

    List<Actor> findByLastName(String lastName);

    List<Actor> findByFirstAndLastName(String firstName, String lastName);

    Actor save(Actor actor);

    void delete(Actor actor);

    void deleteById(Long id);

    void update(Long id, Actor actor);

    Long getTotalAmount();

}
