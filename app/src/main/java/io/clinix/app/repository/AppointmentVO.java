package io.clinix.app.repository;

import java.util.Calendar;

/**
 *
 */
public class AppointmentVO {
    private long appointmentId;
    private String doctorName;
    private String Speciality;
    private String  patientName;
    private Calendar schedule;

    public AppointmentVO(long appointmentId, String doctorName, String speciality, String patientName, Calendar schedule) {
        this.appointmentId = appointmentId;
        this.doctorName = doctorName;
        Speciality = speciality;
        this.patientName = patientName;
        this.schedule = schedule;
    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Calendar getSchedule() {
        return schedule;
    }

    public void setSchedule(Calendar schedule) {
        this.schedule = schedule;
    }
}
