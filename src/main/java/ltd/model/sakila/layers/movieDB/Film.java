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
@Table(name = "\"film\"", schema = "sakila")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILM_ID")
    private Long filmId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RELEASE_YEAR")
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "languageId", referencedColumnName = "LANGUAGE_ID")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "LANGUAGE_ID", nullable = true)
    private Language originalLanguage;

    @Column(name = "RENTAL_DURATION")
    private int rentalDuration;

    @Column(name = "RENTAL_RATE")
    private float rentalRate;

    @Column(name = "LENGTH")
    private int   length;

    @Column(name = "REPLACEMENT_COST")
    private float replacementCost;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(name = "SPECIAL_FEATURES")
    private String specialFeatures;

    @Column(name = "LAST_UPDATE")
    @Temporal(value = TemporalType.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private Date lastUpdate;


}
