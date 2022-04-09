package com.manage.soccer.match_odds;

import com.manage.soccer.matches.Match;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
    @Column(name = "specifier")
    @NotNull
    private String specifier;
    @Column(name = "odd")
    @NotNull
    private Double odd;
}
