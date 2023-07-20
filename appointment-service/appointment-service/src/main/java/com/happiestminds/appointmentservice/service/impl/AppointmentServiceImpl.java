package com.happiestminds.appointmentservice.service.impl;

import com.happiestminds.appointmentservice.entity.Appointment;
import com.happiestminds.appointmentservice.repository.AppointmentRepository;
import com.happiestminds.appointmentservice.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    // create appointment service record
    // http://localhost:8083/appointments
    @Override
    public Appointment saveAppointment(Appointment appointment) {
        Appointment saveAppointment = appointmentRepository.save(appointment);
        return saveAppointment;
    }

    // get all appointment service record
    // http://localhost:8083/appointments
    @Override
    public List<Appointment> getAllAppointment() {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        return appointmentList;
    }

    // get appointment service record by id
    // http://localhost:8083/appointments
    @Override
    public Appointment getAppointmentById(long appointmentId) {
        Appointment appointmentById = appointmentRepository.findById(appointmentId).orElseThrow(null);
        return appointmentById;
    }

    // update appointment service record by id
    // http://localhost:8083/appointments
    @Override
    public Appointment updateAppointment(long appointmentId, Appointment updatedAppointment) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(null);

        Appointment newUpdatedAppointment = appointmentRepository.save(appointment);

        if (newUpdatedAppointment != null){
            newUpdatedAppointment.setTitle(appointment.getTitle());
            newUpdatedAppointment.setStartTime(appointment.getStartTime());
            newUpdatedAppointment.setEndTime(appointment.getEndTime());
            return newUpdatedAppointment;
        }
        return null;
    }

    // delete appointment service record by id
    // http://localhost:8083/appointments
    @Override
    public void deleteAppointment(long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(null);

        appointmentRepository.delete(appointment);
    }
}
