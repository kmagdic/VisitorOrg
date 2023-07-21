package com.visitorOrg.VisitorOrg;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Visitor {

    @Id
    @GeneratedValue
    private Long id;

    String firstName;
    String lastName;
    Date dateOfBirth;
    Date dateOfReservation;
    Date dateVisitStart;
    Date dateVisitEnd;
    String reservationChannel;
    int number_of_guests;
    float amount;
    String notes;

}
