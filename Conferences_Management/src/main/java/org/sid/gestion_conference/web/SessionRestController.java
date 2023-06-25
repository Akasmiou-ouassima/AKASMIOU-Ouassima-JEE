package org.sid.gestion_conference.web;
import org.sid.gestion_conference.dtos.SessionDTO;
import org.sid.gestion_conference.services.ConferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionRestController {
    ConferenceService conferenceService;

    public SessionRestController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }
    @GetMapping("/sessions")
    public List<SessionDTO> sessions(){
        return conferenceService.listSessions();
    }

    @GetMapping("/sessions/{id}")
    public SessionDTO getSession(@PathVariable(name = "id") Long sessionId){
        return conferenceService.getSession(sessionId);
    }
    @PostMapping("sessions")
    public SessionDTO saveSession(@RequestBody SessionDTO sessionDTO){
        return conferenceService.saveSession(sessionDTO);
    }
    @PutMapping("/sessions/{sessionId}")
    public SessionDTO updateSession(@PathVariable Long sessionId,@RequestBody SessionDTO sessionDTO){
        sessionDTO.setId(sessionId);
        return conferenceService.updateSession(sessionDTO);
    }
    @DeleteMapping("/sessions/{id}")
    public void deleteSession(@PathVariable Long id){
        conferenceService.deleteSession(id);
    }

}
