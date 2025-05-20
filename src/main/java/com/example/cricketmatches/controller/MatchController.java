package com.example.cricketmatches.controller;


import com.example.cricketmatches.model.MatchDTO;
import com.example.cricketmatches.service.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private MatchService matchService;
    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    @GetMapping("/today")
    public List<MatchDTO> getTodayMatches(){
        return matchService.getTodayMatches();
    }
}
