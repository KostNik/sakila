package ltd.repository.actor.impl;

import ltd.model.sakila.layers.movieDB.Actor;
import ltd.repository.actor.ActorDAO;
import ltd.repository.actor.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import java.util.List;

@Repository
@Transactional
public class ActorDAOImpl implements ActorDAO {


    @Autowired
    private ActorRepo actorRepo;

    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true, noRollbackFor = Exception.class)
    @Override
    public Actor findById(Long id) {
        return actorRepo.findOne(id);
    }

    @Transactional(readOnly = true, noRollbackFor = Exception.class)
    @Override
    public Long getTotalAmount() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        query.select(builder.count(query.from(Actor.class)));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Transactional(readOnly = true, noRollbackFor = Exception.class)
    @Override
    public List<Actor> findFromTo(long from, long to) {
        return null;
    }

    @Transactional(readOnly = true, noRollbackFor = Exception.class)
    @Override
    public List<Actor> findAll() {
        return actorRepo.findAll();
    }

    @Transactional(readOnly = true, noRollbackFor = Exception.class)
    @Override
    public Page<Actor> findAll(Pageable pageable) {
        return actorRepo.findAll(pageable);
    }

    @Transactional(readOnly = true, noRollbackFor = Exception.class)
    @Override
    public List<Actor> findByFirstName(String firstName) {
        return actorRepo.findByFirstName(firstName);
    }

    @Transactional(readOnly = true, noRollbackFor = Exception.class)
    @Override
    public List<Actor> findByLastName(String lastName) {
        return actorRepo.findByLastName(lastName);
    }

    @Transactional(readOnly = true, noRollbackFor = Exception.class)
    @Override
    public List<Actor> findByFirstAndLastName(String firstName, String lastName) {
        return actorRepo.findByFirstNameAndLastName(firstName, lastName);
    }

    @Transactional(noRollbackFor = Exception.class)
    @Override
    public Actor save(Actor actor) {
        return actorRepo.save(actor);
    }

    @Transactional(noRollbackFor = Exception.class)
    @Override
    public void delete(Actor actor) {

    }

    @Transactional(noRollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {

    }

    @Transactional(noRollbackFor = Exception.class)
    @Override
    public void update(Long id, Actor actor) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        // create update
        CriteriaUpdate<Actor> update = cb.createCriteriaUpdate(Actor.class);
//         set the root class
//        Root e = update.from(Actor.class);
        // set update and where clause
        update.set("firstName", actor.getFirstName());
        update.set("lastName", actor.getLastName());
        // perform update
        entityManager.createQuery(update).executeUpdate();
    }
}
