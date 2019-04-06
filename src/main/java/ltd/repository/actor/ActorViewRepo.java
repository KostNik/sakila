package ltd.repository.actor;

import ltd.model.sakila.layers.movieDB.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActorViewRepo extends JpaRepository<Actor, Long> {

    List<Actor> findByFirstName(String firstName);

    List<Actor> findByLastName(String lastName);

    List<Actor> findByFirstNameAndLastName(String firstName, String lastName);

    List<Actor> findByLastUpdate(Date lastUpdateTime);

}
