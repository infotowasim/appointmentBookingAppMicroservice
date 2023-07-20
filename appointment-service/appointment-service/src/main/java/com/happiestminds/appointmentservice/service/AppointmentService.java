package com.happiestminds.appointmentservice.service;

import com.happiestminds.appointmentservice.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    // create appointment service record
    Appointment saveAppointment(Appointment appointment);

    // get all appointment service record
    List<Appointment> getAllAppointment();

    // get appointment service record by id
    Appointment getAppointmentById(long appointmentId);

    // update appointment service record by id
    Appointment updateAppointment(long appointmentId, Appointment updatedAppointment);

    // delete appointment service record by id
    void deleteAppointment(long appointmentId);
}
