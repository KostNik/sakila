package ltd.controller;


import lombok.Data;
import ltd.model.sakila.layers.movieDB.Actor;

import java.util.List;

@Data
public class ActorGrid {
    private int         totalPages;
    private int         currentPage;
    private long        totalRecords;
    private List<Actor> actorData;
}
