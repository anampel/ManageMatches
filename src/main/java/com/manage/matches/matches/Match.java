package com.manage.matches.matches;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.manage.matches.utils.TimeDeserializer;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
/**
 * Match object
 * */
@Table(name = "MATCH", uniqueConstraints = { @UniqueConstraint(name = "UniqueMatch", columnNames = {"match_date", "team_a", "team_b"})})
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date match_date;
    @NotNull
    private String team_a;
    @NotNull
    private String team_b;
    private String sport;
    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "hh:mm")
    @JsonDeserialize(using = TimeDeserializer.class)
    private Date match_time;

}
