package ltd.model.sakila.layers.movieDB;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "\"film_text\"", schema = "sakila")
public class FilmText implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "FILM_ID")
    private Film film;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

}
