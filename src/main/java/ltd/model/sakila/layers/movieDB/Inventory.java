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
@Table(name = "\"inventory\"", schema = "sakila")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVENTORY_ID")
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "FILM_ID")
    private Film film;

    //    @ManyToOne
//    @JoinColumn(name = "STORE_ID")
//    private Store store;

    @Column(name = "LAST_UPDATE")
    @Temporal(value = TemporalType.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private Date lastUpdate;


}
