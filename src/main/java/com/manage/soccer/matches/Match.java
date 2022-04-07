package com.manage.soccer.matches;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Table(name = "MATCH")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date match_date;
    private ZonedDateTime match_time;
    private String team_a;
    private String team_b;
    private Sport sport;
}
