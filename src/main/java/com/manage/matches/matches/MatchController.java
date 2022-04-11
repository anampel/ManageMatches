package com.manage.matches.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * Match Controller
 * Java class that connect with Match Service.
 * Requests and Responses http verbs.
 * */
@RestController
@RequestMapping(path="api/match")
public class MatchController {
    private MatchService matchService;
    /**
     * Constructor
     * */
    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    /**
     * find a match by id
     * @param id
     * */
    @GetMapping("/findMatch")
    public Optional<Match> findMatch(@RequestParam Long id){
        return matchService.findMatchById(id);
    }

    /**
     * add a new match
     * @param match object
     * */
    @PostMapping("/addNewMatch")
    public String addNewMatch(@RequestBody Match match) {
        matchService.addNewMatch(match);
        return "Success";
    }

    /**
     * find a match by match odds
     * @param odd
     * */
    @GetMapping("/findMatchByMatchOdds")
    public List<Match> findMatchByMatchOdds(@RequestParam Double odd) {
        return matchService.findByMatchOdds(odd);

    }
    /**
     * edit a match
     * @param match object
     * */
    @PutMapping("/editMatch")
    public String editMatch(@RequestBody Match match){
        matchService.editMatch(match);
        return "Success";
    }
    /**
     * delete a match by id
     * @param id
     * */
    @DeleteMapping("/deleteMatch")
    public String delete(@RequestParam Long id){
        matchService.deleteMatch(id);
        return "Success";
    }
}
