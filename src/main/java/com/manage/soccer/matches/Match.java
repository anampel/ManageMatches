package com.manage.soccer.matches;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "MATCH")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "match_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date match_date;
    @Column(name = "team_a")
    private String team_a;
    @Column(name = "team_b")
    private String team_b;
    @Column(name = "sport")
    private Sport sport;
    @Temporal(TemporalType.TIME)
    @Column(name = "match_time")
    private java.util.Date match_time;

}
