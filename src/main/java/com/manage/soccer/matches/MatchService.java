package com.manage.soccer.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Optional<Match> findMatchById(Long id){
       return matchRepository.findMatchById(id);
    }

    public void addNewMatch(Match match){
//        Optional<Match> matchById = matchRepository.findMatchById();
//        if (productByName.isPresent()) {
//            throw new IllegalStateException("The product already exists!!");
//        }

        matchRepository.save(match);
    }

    public void editMatch(Match match){
        Optional<Match> matchById = matchRepository.findMatchById(match.getId());
        if (matchById.isPresent()) {
            matchRepository.save(match);
        }else{
            throw new IllegalArgumentException("The match_id: " + match.getId() + " does not exist!");
        }
    }

    public void deleteMatch(Long id){
        Optional<Match> matchById = matchRepository.findMatchById(id);
        if (matchById.isPresent()) {
            matchRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("The match_id: " + id + " does not exist!");
        }
    }
}
