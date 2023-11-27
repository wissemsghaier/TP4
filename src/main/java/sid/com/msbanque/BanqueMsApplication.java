package sid.com.msbanque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;
import sid.com.msbanque.entities.Client;
import sid.com.msbanque.entities.Compte;
import sid.com.msbanque.entities.TypeCompte;
import sid.com.msbanque.repositorie.ClientRepository;
import sid.com.msbanque.repositorie.CompteRepository;

import java.util.Date;

@SpringBootApplication
@Component
public class BanqueMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueMsApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration repositoryRestConfiguration, ClientRepository clientRepository){
		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Compte.class);
			Client c1= clientRepository.save(new Client(null,"wissem",null));
			Client c2= clientRepository.save(new Client(null,"ziden",null));
			Client c3= clientRepository.save(new Client(null,"hama",null));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE,c1));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT,c2));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE,c3));
			compteRepository.findAll().forEach(c->{
				System.out.println(c.getSolde());
			});
		};
	}



}
