package com.visitorOrg.VisitorOrg;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Data
@Entity
public class Visitor {

    @Id
    @GeneratedValue
    private Long id;

    String firstName;
    String lastName;
    Date dateOfBirth;
    Date dateOfReservation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateVisitStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateVisitEnd;
    String reservationChannel;
    int number_of_guests;
    float amount;
    String notes;

    public int visitDuration() {
        if(dateVisitStart == null || dateVisitEnd == null)
            return 0;

        Period period = Period.between(convertToLocalDate(dateVisitStart),
                                    convertToLocalDate(dateVisitEnd));
        return period.getDays();
    }

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(
                dateToConvert.toInstant(), ZoneId.systemDefault());
    }


}
