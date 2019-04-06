package ltd.model.sakila.layers.movieDB;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import ltd.controller.CustomDateTimeDeserializer;
import ltd.controller.CustomDateTimeSerializer;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "\"film_actor\"", schema = "sakila")
public class FilmActor {

    @EmbeddedId
    private FilmActorID filmActorID;

    @Column(name = "LAST_UPDATE")
    @Temporal(value = TemporalType.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private Date        lastUpdate;


}
