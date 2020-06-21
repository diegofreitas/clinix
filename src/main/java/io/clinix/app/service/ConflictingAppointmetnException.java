package io.clinix.app.service;


public class ConflictingAppointmetnException extends RuntimeException{

    public ConflictingAppointmetnException(String message) {
        super(message);
    }
}
