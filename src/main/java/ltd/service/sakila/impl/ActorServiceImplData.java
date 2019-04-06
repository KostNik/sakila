package ltd.service.sakila.impl;

import ltd.model.sakila.layers.movieDB.Actor;
import ltd.repository.actor.ActorDAO;
import ltd.service.sakila.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImplData implements ActorService {

    @Autowired
    private ActorDAO actorDAO;

    @Override
    public Actor findById(Long id) {
        return actorDAO.findById(id);
    }

    @Override
    public List<Actor> findAll() {
        return actorDAO.findAll();
    }

    @Override
    public Page<Actor> findAllByPage(Pageable pageable) {
        return actorDAO.findAll(pageable);
    }

    @Override
    public List<Actor> findByFirstName(String firstName) {
        return actorDAO.findByFirstName(firstName);
    }

    @Override
    public List<Actor> findByLastName(String lastName) {
        return actorDAO.findByLastName(lastName);
    }

    @Override
    public List<Actor> findByFirstAndLastName(String firstName, String lastName) {
        return actorDAO.findByFirstAndLastName(firstName, lastName);
    }

    @Override
    public Actor save(Actor actor) {
        return actorDAO.save(actor);
    }

    @Override
    public void delete(Actor actor) {
        actorDAO.delete(actor);
    }

    @Override
    public void deleteById(Long id) {
        actorDAO.deleteById(id);
    }

    @Override
    public void update(Long id, Actor actor) {
        actorDAO.update(id, actor);
//        Actor updated = findById(id);
//        String SQL = "UPDATE ACTOR SET FIRST_NAME = :FIRST_NAME, LAST_NAME = :LAST_NAME WHERE ACTOR_ID = :ACTOR_ID";
//        Map<String, Object> params = new HashMap<>();
//        params.put("ACTOR_ID", updated.getId());
//        params.put("FIRST_NAME", actor.getFirstName());
//        params.put("LAST_NAME", actor.getLastName());
//        jdbcTemplate.update(SQL, params);
    }

    @Override
    public Long getTotalAmount() {
        return actorDAO.getTotalAmount();
    }


}
