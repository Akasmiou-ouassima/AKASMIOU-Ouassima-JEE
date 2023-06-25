package org.sid.gestion_conference.web;

import org.sid.gestion_conference.dao.entities.Conference;
import org.sid.gestion_conference.dtos.ConferenceDTO;
import org.sid.gestion_conference.services.ConferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceRestController {
     private ConferenceService conferenceService;

    public ConferenceRestController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/conferences")
    public List<ConferenceDTO> conferences(){
        return conferenceService.listConferences();
    }

    @GetMapping("/conferences/{id}")
    public ConferenceDTO getConference(@PathVariable(name = "id") Long conferenceId){
        return conferenceService.getConference(conferenceId);
    }
    @PostMapping("conferences")
    public ConferenceDTO saveConference(@RequestBody ConferenceDTO conferenceDTO){
        return conferenceService.saveConference(conferenceDTO);
    }
    @PutMapping("/conferences/{conferenceId}")
    public ConferenceDTO updateConference(@PathVariable Long conferenceId,@RequestBody ConferenceDTO conferenceDTO){
        conferenceDTO.setId(conferenceId);
        return conferenceService.updateConference(conferenceDTO);
    }
    @DeleteMapping("/conferences/{id}")
    public void deleteConference(@PathVariable Long id){
        conferenceService.deleteConference(id);
    }

}
