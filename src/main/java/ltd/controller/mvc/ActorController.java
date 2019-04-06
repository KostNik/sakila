package ltd.controller.mvc;

import ltd.model.sakila.layers.movieDB.Actor;
import ltd.service.sakila.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("web/actors")
public class ActorController {


    @Autowired
    private Environment environment;

    @Autowired
    private ActorService actorService;

    @GetMapping("/all")
    public String all(Model model) {
        setAllActorsToModel(model);
        return "actors/actors";
    }

    @GetMapping("/list")
    public String list(Model model) {
        setAllActorsToModel(model);
        return "actors/list";
    }

    private void setAllActorsToModel(Model model) {
        List<Actor> list = actorService.findAll();
        Map<String, List<Actor>> params = new HashMap<>();
        params.put("actors", list);
        model.addAllAttributes(params);
    }

    @GetMapping("/actor/{id}")
    public String actor(@PathVariable("id") Long id, Model model) {
        Actor actor = actorService.findById(id);
        Map<String, Object> params = new HashMap<>();
        params.put("actor", actor);
        model.addAllAttributes(params);
        return "actors/actor";
    }

}
