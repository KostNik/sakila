package ltd.controller.rest.movieDB;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import ltd.controller.ActorGrid;
import ltd.model.sakila.layers.movieDB.Actor;
import ltd.service.sakila.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("rest/actors")
@Slf4j
public class RestActorController {

    @Autowired
    private ActorService actorService;


    @GetMapping(value = "/actor", produces = "application/json")
    public @ResponseBody
    Actor read(@RequestParam("id") Long actorId) {
        return actorService.findById(actorId);
    }


    @GetMapping(value = "/amount", produces = "application/json")
    public @ResponseBody
    Long totalAmount() {
        return actorService.getTotalAmount();
    }


    @GetMapping(value = "", produces = "application/json")
    public @ResponseBody
    List<Actor> readAll() {
        return actorService.findAll();
    }

    @GetMapping(value = "/filter/{fullName}", produces = "application/json")
    public List<Actor> readByFirstAndLastName(@MatrixVariable(pathVar = "fullName") Map<String, List<String>> fullNameParams) {
        List<String> firstName = fullNameParams.get("firstName");
        List<String> lastName = fullNameParams.get("lastName");
        if (nonNull(firstName) && isNull(lastName)) {
            return actorService.findByFirstName(firstName.get(0));
        }
        if (isNull(firstName) && nonNull(lastName)) {
            return actorService.findByLastName(lastName.get(0));
        }
        return actorService.findByFirstAndLastName(firstName.get(0), lastName.get(0));
    }

    @PostMapping(value = "/actor")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Actor saveActor(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

    @DeleteMapping(value = "/actor")
    public ResponseEntity deleteActor(@RequestParam("id") Long actorId) {
        try {
            actorService.deleteById(actorId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/actor")
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestParam("id") Long actorId,
                       @RequestBody Actor actor) {
        actor.setId(actorId);
        actorService.update(actorId, actor);
    }


    @GetMapping(value = "/listgrid", produces = "application/json")
    @ResponseBody
    public ActorGrid listGrid(
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "rows") Integer rows,
            @RequestParam(value = "sort", required = false) String sortBy,
            @RequestParam(value = "order", required = false) String order
    ) {
        log.info("Listing contact for grid with page:" + page + " rows: " + rows);
        log.info("Listing contact for grid with sort:" + sortBy + " order: " + order);

        Sort sort = null;
        if (sortBy != null && order != null) {
            if (order.equals("desc")) {
                sort = new Sort(Sort.Direction.DESC, sortBy);
            } else {
                sort = new Sort(Sort.Direction.ASC, sortBy);
            }
        }

        PageRequest pageRequest;
        if (sort != null) {
            pageRequest = new PageRequest(page - 1, rows, sort);
        } else {
            pageRequest = new PageRequest(page - 1, rows);
        }

        Page<Actor> actorPage = actorService.findAllByPage(pageRequest);

        ActorGrid actorGrid = new ActorGrid();
        actorGrid.setCurrentPage(actorPage.getNumber() + 1);
        actorGrid.setTotalPages(actorPage.getTotalPages());
        actorGrid.setTotalRecords(actorPage.getTotalElements());
        actorGrid.setActorData(Lists.newArrayList(actorPage.iterator()));

        return actorGrid;
    }
}

