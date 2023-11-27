package sid.com.msbanque.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sid.com.msbanque.entities.Client;
import sid.com.msbanque.entities.Compte;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {


}
