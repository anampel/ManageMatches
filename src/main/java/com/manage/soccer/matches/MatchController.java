package com.manage.soccer.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/match")
public class MatchController {
    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/findMatch")
    public Optional<Match> findMatch(@RequestParam Long id){
        return matchService.findMatchById(id);
    }

    @PostMapping("/addNewMatch")
    public String addNewMatch(@RequestBody Match match) {
        matchService.addNewMatch(match);
        return "Success";
    }

    @GetMapping("/findMatchByMatchOdds")
    public List<Match> findMatchByMatchOdds(@RequestParam Double odd) {
        return matchService.findByMatchOdds(odd);

    }

    @PutMapping("/editMatch")
    public String editMatch(@RequestBody Match match){
        matchService.editMatch(match);
        return "Success";
    }

    @DeleteMapping("/deleteMatch")
    public String delete(@RequestParam Long id){
        matchService.deleteMatch(id);
        return "Success";
    }
}
