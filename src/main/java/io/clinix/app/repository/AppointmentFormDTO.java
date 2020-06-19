package io.clinix.app.repository;

import lombok.Getter;

import java.util.Calendar;

@Getter
public class AppointmentFormDTO {
    private Long doctorId;
    private Long  patientId;
    private Calendar schedule;
}
