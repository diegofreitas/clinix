package io.clinix.app.repository;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentFormDTO {
    @NotNull
    private Long doctorId;
    @NotNull
    private Long  patientId;
    @NotNull
    private LocalDateTime schedule;
}
