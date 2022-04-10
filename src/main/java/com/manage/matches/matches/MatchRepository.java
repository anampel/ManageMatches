package com.manage.matches.matches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Optional<Match> findMatchById(Long id);

    @Query("SELECT m FROM Match m, MatchOdds mo WHERE mo.match.id = m.id and mo.odd=?1")
    List<Match> findMatchByMatchOdds(Double odd);


}
