package io.clinix.app.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import io.clinix.app.repository.AppointmentFormDTO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.springframework.test.util.AssertionErrors.assertTrue;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest()
@TestExecutionListeners({
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@Transactional
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    @DatabaseSetup(value = "/appointments_conflicting_scenario.xml", type = DatabaseOperation.INSERT)
    public void shouldNotCreateAppointmetForPatientAndDoctorSameDateTime() {
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("Conflinting appointment");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse("2020-06-20 00:00:00", formatter);
        Calendar scheduleTime = GregorianCalendar.from(dt.atZone(ZoneId.systemDefault()));
        appointmentService.createAppointment(
                AppointmentFormDTO.builder()
                        .doctorId(1l)
                        .patientId(1l)
                        .schedule(scheduleTime).build()
        );
    }

}

