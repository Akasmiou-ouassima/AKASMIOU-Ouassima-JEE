package ma.enset.etudiants.web;

import jakarta.validation.Valid;
import ma.enset.etudiants.entities.Etudiant;
import ma.enset.etudiants.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @GetMapping("/user/index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "5") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String kw
                        ){
        Page<Etudiant> pageEtudiants = etudiantRepository.findByNomContains(kw, PageRequest.of(page,size));
        model.addAttribute("listEtudiants",pageEtudiants.getContent());
        model.addAttribute("pages",new int[pageEtudiants.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return "etudiants";
    }
    @GetMapping("/admin/deleteEtudiant")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteEtudiant(@RequestParam(name = "id") Long id, String keyword, int page){
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/formEtudiant")
    public String formEtudiant(Model model ){
        model.addAttribute("etudiant",new Etudiant());
        return "formEtudiant";
    }
    @PostMapping("/admin/saveEtudiant")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveEtudiant(@Valid Etudiant etudiant, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "formEtudiant";
        etudiantRepository.save(etudiant);
        return "formEtudiant";
    }
    @GetMapping("/admin/editEtudiant")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editEtudiant(@RequestParam(name = "id") Long id, Model model){
        Etudiant etudiant=etudiantRepository.findById(id).get();
        model.addAttribute("etudiant",etudiant);
        return "editEtudiant";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }




}
