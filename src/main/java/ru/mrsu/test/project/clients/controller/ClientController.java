package ru.mrsu.test.project.clients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import ru.mrsu.test.project.clients.jpa.ClientRepository;
import ru.mrsu.test.project.clients.jpa.ClientRepository;
import ru.mrsu.test.project.clients.service.AdressService;
import ru.mrsu.test.project.clients.service.ClientService;
import ru.mrsu.test.project.clients.service.object.Client;

import java.util.List;

@RestController
@RequestMapping(value = "", produces = "application/json")
public class ClientController {
    private final ClientService clientService;
    private final AdressService adressService;

    private final ClientRepository clientRepository;

    public ClientController (ClientService clientService, AdressService adressService, ClientRepository clientRepository){
        this.clientService = clientService;
        this.adressService = adressService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("internal/clients")
    public List<Client> getClient(){
        adressService.getAdress();
        return clientService.getClients();
    }

    @RequestMapping("createClients")
    public void setClients () {
        clientRepository.saveAll(getClient());
    }
}
