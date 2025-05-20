package com.example.cricketmatches.service;

import com.example.cricketmatches.model.MatchDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class MatchService {

    private static final Logger log = LoggerFactory.getLogger(MatchService.class);

    @Value("${cricket.api.url}")
    private String apiUrl;

    @Value("${cricket.api.key}")
    private String apiKey;

    public List<MatchDTO> getTodayMatches() {


        //A RestTemplate object is created to make HTTP GET requests to external APIs.
        RestTemplate restTemplate = new RestTemplate();

        //        Builds the full API URL with your API key, e.g.:
        String url = apiUrl + "?apiKey=" + apiKey + " &offset=0";

        log.info("Calling Cricket API: {}", url);

        //Sends the GET request.
        //
        //Receives a JSON response, which is deserialized into a generic Map.
        List<MatchDTO> result = null;
        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            log.debug("Received API response: {}", response);

            if (response == null || !response.containsKey("data")) {
                log.warn("API call failed or 'data' field missing in response.");
                return new ArrayList<>();
            }

            //from the JSON, it extracts the "data" array that contains match info.
            List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
            log.info("Total matches received: {}", data.size());


            // Fix: Null check before using the list
            if (data == null || data.isEmpty()) {
                log.warn("No match data found in API response");
                return new ArrayList<>(); // return empty list instead of crashing
            }


            //        Prepares a list to hold only today’s matches.
            //Gets today's date in YYYY-MM-DD format.
            result = new ArrayList<>();
            String today = LocalDate.now().toString();

            //        Loops through each match.
            //
            //        Extracts the match date.

            //        Compares it with today’s date.
            if (data != null) {
                for (Map<String, Object> item : data) {
                    String date = item.get("dateTimeGMT").toString().substring(0, 10);
                    if (today.equals(date)) {

//                If match is happening today, it creates a MatchDTO object and fills it.
//                        Adds it to the result list.
//                        Finally returns a list of today’s matches to the controller.
//
                        MatchDTO match = new MatchDTO();
                        match.setName(item.get("name").toString());
                        match.setDate(date);
                        match.setVenue(item.get("venue").toString());
                        match.setMatchStarted((Boolean) item.get("matchStarted"));
                        result.add(match);
                        log.info("Match added for today: {}", match);
                    }
                }
                log.info("Total matches found for today: {}", result.size());
            } else {
                log.warn("API call failed or 'data' field missing in response.");
            }
        } catch (Exception e) {
            log.error("Error while fetching matches from API", e);
        }
        return result;


    }
}
