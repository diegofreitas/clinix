package io.clinix.app.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import com.github.springtestdbunit.annotation.ExpectedDatabase;
import io.clinix.app.repository.AppointmentFormDTO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest()
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
@Transactional
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    @DatabaseSetup(value = "/appointments_conflicting_scenario.xml", type = DatabaseOperation.CLEAN_INSERT)
    public void shouldNotCreateAppointmetForPatientAndDoctorSameDateTime() {
        exceptionRule.expect(ConflictingAppointmetnException.class);
        exceptionRule.expectMessage("Conflinting appointment");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse("2020-06-20 00:00:00", formatter);
        appointmentService.createAppointment(
                AppointmentFormDTO.builder()
                        .doctorId(1l)
                        .patientId(1l)
                        .schedule(dt).build()
        );
    }

    @Test
    @DatabaseSetup(value = "/appointments_conflicting_scenario.xml", type = DatabaseOperation.CLEAN_INSERT)
    public void shouldNotCreateAppointmetForDoctorSameDateTime() {
        exceptionRule.expect(ConflictingAppointmetnException.class);
        exceptionRule.expectMessage("Conflinting appointment");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse("2020-06-20 02:00:00", formatter);
        appointmentService.createAppointment(
                AppointmentFormDTO.builder()
                        .doctorId(2l)
                        .patientId(2l)
                        .schedule(dt).build()
        );
    }


    @Test
    @DatabaseSetup(value = "/appointments_conflicting_scenario.xml", type = DatabaseOperation.CLEAN_INSERT)
    public void shouldNotCreateAppointmetForPatientSameDateTime() {
        exceptionRule.expect(ConflictingAppointmetnException.class);
        exceptionRule.expectMessage("Conflinting appointment");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse("2020-06-21 02:00:00", formatter);

        appointmentService.createAppointment(
                AppointmentFormDTO.builder()
                        .doctorId(3l)
                        .patientId(3l)
                        .schedule(dt).build()
        );
    }

    @Test
    @DatabaseSetup(value = "/scenario_shouldCreateAnotherAppointmetForPatientAndDoctorAfter60Min.xml", type = DatabaseOperation.CLEAN_INSERT)
    @ExpectedDatabase(value="/assert_shouldCreateAnotherAppointmetForPatientAndDoctorAfter60Min.xml", table = "appointment")
    @Rollback(false)
    public void shouldCreateAnotherAppointmetForPatientAndDoctorAfter60Min() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse("2020-06-21 01:00:00", formatter);
        appointmentService.createAppointment(
                AppointmentFormDTO.builder()
                        .doctorId(1l)
                        .patientId(1l)
                        .schedule(dt).build()
        );
    }

    @Test
    @DatabaseSetup(value = "/scenario_shouldCreateAnotherAppointmetForPatientAndDoctorBefore60Min.xml", type = DatabaseOperation.CLEAN_INSERT)
    @ExpectedDatabase(value="/assert_shouldCreateAnotherAppointmetForPatientAndDoctorBefore60Min.xml", table = "appointment")
    @Rollback(false)
    public void shouldCreateAnotherAppointmetForPatientAndDoctorBefore60Min() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse("2020-06-20 23:00:00", formatter);
        appointmentService.createAppointment(
                AppointmentFormDTO.builder()
                        .doctorId(1l)
                        .patientId(1l)
                        .schedule(dt).build()
        );
    }


}

