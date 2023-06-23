
package ru.mrsu.test.project.clients.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mrsu.test.project.clients.service.object.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}

