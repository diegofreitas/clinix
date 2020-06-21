package io.clinix.app.repository;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentFormDTO {
    private Long doctorId;
    private Long  patientId;
    private LocalDateTime schedule;
}
