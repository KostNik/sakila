package ltd.model.sakila.layers.movieDB;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Embeddable
public class FilmCategoryID implements Serializable {

    @OneToOne
    @JoinColumn(name = "FILM_ID")
    private Film film;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

}
