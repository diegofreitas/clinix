package io.clinix.app.model;

import lombok.*;
import javax.persistence.*;
import java.util.Calendar;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    private Calendar schedule;

}
