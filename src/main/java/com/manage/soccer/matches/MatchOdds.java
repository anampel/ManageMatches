package com.manage.soccer.matches;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "MATCH_ODDS")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatchOdds {
    @Id
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id")
    private List<Match> matches = new ArrayList<>();
    private String specifiers;
    private Double odd;
}
