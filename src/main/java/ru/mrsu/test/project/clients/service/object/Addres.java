package ru.mrsu.test.project.clients.service.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ADDRES")
@AllArgsConstructor
@NoArgsConstructor
public class Addres {
    @Id
    @Column(name = "addres_id" )
    public int id;           // идентификатор

    @Column(name = "addres_city" )
    public String city;         // город

    @Column(name = "addres_street")
    public String street;       // улица

    @Column(name = "addres_house")
    public int house;        // дом

    @Column(name = "addres_floor")
    public int floor;        // этаж

    @Column(name = "addres_flatNamber")
    public int flatNumber;   // квартира
    public String toStringAddress() {
        return id + " " + city + " " + street + " " + house + " " + floor + " " + flatNumber;
    }

}