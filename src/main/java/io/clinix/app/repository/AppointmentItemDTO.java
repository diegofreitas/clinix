package io.clinix.app.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 *
 */
@Data
@AllArgsConstructor
public class AppointmentItemDTO {
    private Long appointmentId;
    private String doctorName;
    private String Speciality;
    private String  patientName;
    private LocalDateTime schedule;

}
