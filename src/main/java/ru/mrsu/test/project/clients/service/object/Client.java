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
@Table (name = "Clients")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @Column(name = "client_id" )
    public int id;              // идентификатор

    @Column(name = "client_name" )
    public String name;            // ФИО

    @Column(name = "client_personnelNumber" )
    public String personnelNumber; // персональный номер

    @Column(name = "client_address" )
    public int address;         // адрес проживания

    public String toString() {
        String string = id + " " + name + " " + personnelNumber + " " + address;
        return string;
    }

}
