package com.happiestminds.appointmentservice.controller;

import com.happiestminds.appointmentservice.entity.Appointment;
import com.happiestminds.appointmentservice.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    // create appointment service record
    // http://localhost:8083/appointments
    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment){
        Appointment saveAppointment = appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>(saveAppointment, HttpStatus.CREATED);
    }

    // get all appointment service record
    // http://localhost:8083/appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointment(){
        List<Appointment> appointmentList = appointmentService.getAllAppointment();
        return ResponseEntity.ok(appointmentList);
    }

    // get appointment service record by id
    // http://localhost:8083/appointments
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") long appointmentId){
        Appointment appointmentById = appointmentService.getAppointmentById(appointmentId);
        return ResponseEntity.ok(appointmentById);
    }

    // update appointment service record by id
    // http://localhost:8083/appointments
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long appointmentId, @RequestBody Appointment updatedAppointment){
        Appointment existingAppointment = appointmentService.updateAppointment(appointmentId, updatedAppointment);

        if (existingAppointment != null){
            return new ResponseEntity<>(existingAppointment, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete appointment service record by id
    // http://localhost:8083/appointments
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") long appointmentId){
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.ok("Appointment service record deleted successfully");
    }
}
