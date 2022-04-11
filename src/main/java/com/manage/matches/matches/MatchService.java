package com.manage.matches.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
/**
 * Match Service
 * Java class that connect with Match Repository in order to access the DB
 * */
@Service
public class MatchService {
    private MatchRepository matchRepository;
    /**
     * Constructor
     * */
    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    /**
     * find a match by id service implementation
     * @param id
     * */
    public Optional<Match> findMatchById(Long id) {
        Optional<Match> responseMatch = matchRepository.findMatchById(id);
        if (responseMatch.isPresent())
            responseMatch.get().setSport(Sport.getSportNameByCode(responseMatch.get().getSport()));
        return responseMatch;
    }

    /**
     * find a match by match odds service implementation
     * @param odd
     * */
    public List<Match> findByMatchOdds(Double odd) {
        return matchRepository.findMatchByMatchOdds(odd);
    }
    /**
     * add a new match service implementation
     * @param match object
     * */
    public void addNewMatch(Match match){
        try {

            match.setSport(Sport.getSportCodeByName(match.getSport()));
            matchRepository.save(match);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * edit a match service implementation
     * @param match object
     * */
    public void editMatch(Match match) {
        Optional<Match> matchById = matchRepository.findMatchById(match.getId());
        if (matchById.isPresent()) {
            match.setSport(Sport.getSportCodeByName(match.getSport()));
            matchRepository.save(match);
        } else {
            throw new IllegalArgumentException("The match_id: " + match.getId() + " does not exist!");
        }
    }
    /**
     * delete a match by id service implementation
     * @param id
     * */
    public void deleteMatch(Long id) {
        Optional<Match> matchById = matchRepository.findMatchById(id);
        if (matchById.isPresent()) {
            matchRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("The match_id: " + id + " does not exist!");
        }
    }
}
