package org.sid.gestion_conference.web;

import org.sid.gestion_conference.dtos.InscriptionDTO;
import org.sid.gestion_conference.services.ConferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InscriptionRestController {
    ConferenceService conferenceService;

    public InscriptionRestController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }
    @GetMapping("/inscriptions")
    public List<InscriptionDTO> inscriptions(){
        return conferenceService.listInscriptions();
    }

    @GetMapping("/inscriptions/{id}")
    public InscriptionDTO getInscription(@PathVariable(name = "id") Long inscriptionId){
        return conferenceService.getInscription(inscriptionId);
    }
    @PostMapping("inscriptions")
    public InscriptionDTO saveConference(@RequestBody InscriptionDTO inscriptionDTO){
        return conferenceService.saveInscription(inscriptionDTO);
    }
    @PutMapping("/inscriptions/{inscriptionId}")
    public InscriptionDTO updateInscription(@PathVariable Long inscriptionId,@RequestBody InscriptionDTO inscriptionDTO){
        inscriptionDTO.setId(inscriptionId);
        return conferenceService.updateInscription(inscriptionDTO);
    }
    @DeleteMapping("/inscriptions/{id}")
    public void deleteInscription(@PathVariable Long id){
        conferenceService.deleteInscription(id);
    }
}
