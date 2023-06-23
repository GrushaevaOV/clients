package ru.mrsu.test.project.clients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrsu.test.project.clients.jpa.AddressRepository;
import ru.mrsu.test.project.clients.service.AdressService;
import ru.mrsu.test.project.clients.service.object.Addres;

import java.util.List;

@RestController
public class AddresController {
    private final AdressService adressService;

    private final AddressRepository addressRepository;

    public AddresController (AdressService adressService, AddressRepository addressRepository){
        this.adressService = adressService;
        this.addressRepository = addressRepository;
    }
    @GetMapping("internal/addres")
    public List<Addres> getAdress(){
        return adressService.getAdress();
    }

    @RequestMapping("createAdress")
    public void setClients () {
        addressRepository.saveAll(getAdress());
    }
}