package ru.mrsu.test.project.clients.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import ru.mrsu.test.project.clients.service.AdressService;
import ru.mrsu.test.project.clients.service.object.Addres;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Service
public class AddresServiceImpl implements AdressService {
    public static List<Addres> addresList = new ArrayList<>();
    private final ResourceLoader resourceLoader;

    public AddresServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public List<Addres> getAdress() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:address.xml");
            InputStream inputStream = resource.getInputStream();
            parser = factory.createXMLStreamReader(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException | IOException e) {
            System.out.println(e.getMessage());
        }
        List<Addres> addreses = new ArrayList<>();
        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("address")) {
                        Addres add = new Addres();
                        add.setId(Integer.parseInt(parser.getAttributeValue(0)));
                        add.setCity(parser.getAttributeValue(1));
                        add.setStreet(parser.getAttributeValue(2));
                        add.setHouse(Integer.parseInt(parser.getAttributeValue(3)));
                        add.setFloor(Integer.parseInt(parser.getAttributeValue(4)));
                        add.setFlatNumber(Integer.parseInt(parser.getAttributeValue(5)));
                        addreses.add(add);
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        addresList=addreses;
        return addreses;
    }
}


