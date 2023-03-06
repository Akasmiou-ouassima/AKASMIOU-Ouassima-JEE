package ma.enset.jpaap;

import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class JpaApApplicationTests implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	@Override
	public void run(String... args) throws Exception {
		//patientRepository.save(new Patient(null, "hassan",new Date(),true,100));
		//patientRepository.save(new Patient(null,"Mohamed",new Date(),false,100));
		//patientRepository.save(new Patient(null,"Imane",new Date(),false,210));
		for (int i=0;i<100;i++){
			patientRepository.save(new Patient(null,"hassan",new Date(),Math.random()>0.5?true:false,(int)(Math.random())*100));
		}
		Page<Patient> patients=patientRepository.findAll(PageRequest.of(0,5)); //affiche 5 patients de premier page

		System.out.println("Total pages :"+patients.getTotalPages());// retourne le nombre total de pages
		System.out.println("Total Elements :"+patients.getTotalElements());//le nombre total des elements
		System.out.println("Num Page :"+patients.getNumber());//le numéro de la page
        List<Patient> content=patients.getContent();//liste de patients
		//List<Patient> byMalade= patientRepository.findByMalade(true);
		Page<Patient> byMalade= patientRepository.findByMalade(true,PageRequest.of(0,4));
		List<Patient> patientList=patientRepository.chercherPatients("%h%",40);
		//patients.forEach(p->{
		content.forEach(p->{
			System.out.println("==============================");
			System.out.println(p.getId());
			System.out.println(p.getNom());
			System.out.println(p.getScore());
			System.out.println(p.getDateNaissance());
			System.out.println(p.isMalade());
		});
		System.out.println("******************************************");
		// Patient patient=patientRepository.findById(1L).orElseThrow(()-> new RuntimeException("Patient not found"));
	     Patient patient=patientRepository.findById(1L).orElse(null);
		  if(patient!=null){
			  System.out.println(patient.getNom());
			  System.out.println(patient.isMalade());
		  }
		  patient.setScore(870);
		  patientRepository.save(patient);
		  patientRepository.deleteById(1L);

	}
}
