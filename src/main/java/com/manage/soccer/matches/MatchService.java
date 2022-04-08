package com.manage.soccer.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class MatchService {
    private MatchRepository matchRepository;
    private static final String timeFormat ="HH:mm:ss";
    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Optional<Match> findMatchById(Long id) {
        return matchRepository.findMatchByMatch_id(id);
    }

    public void addNewMatch(Match match){
        try {
            match.setMatch_time(new SimpleDateFormat(timeFormat).parse("15:30:14"));
            matchRepository.save(match);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editMatch(Match match) {
        Optional<Match> matchById = matchRepository.findMatchByMatch_id(match.getId());
        if (matchById.isPresent()) {
            matchRepository.save(match);
        } else {
            throw new IllegalArgumentException("The match_id: " + match.getId() + " does not exist!");
        }
    }

    public void deleteMatch(Long id) {
        Optional<Match> matchById = matchRepository.findMatchByMatch_id(id);
        if (matchById.isPresent()) {
            matchRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("The match_id: " + id + " does not exist!");
        }
    }
}
