package io.clinix.app.repository;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AppointmentFormDTO {
    private Long doctorId;
    private Long  patientId;
    private LocalDateTime schedule;
}
