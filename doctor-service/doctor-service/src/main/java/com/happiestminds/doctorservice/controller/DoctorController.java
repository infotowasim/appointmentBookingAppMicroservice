package com.happiestminds.doctorservice.controller;

import com.happiestminds.doctorservice.entity.Doctor;
import com.happiestminds.doctorservice.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    // create doctor service record
    // http://localhost:8082/doctors
    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        Doctor saveDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(saveDoctor, HttpStatus.CREATED);
    }

    // get all doctor service record
    // http://localhost:8082/doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> doctorList = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctorList);
    }

    // get doctor service record by id
    // http://localhost:8082/doctors/1
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") long doctorId){
        Doctor doctorById = doctorService.getDoctorById(doctorId);
        if (doctorById != null){
            return ResponseEntity.ok(doctorById);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // update doctor service by id
    // http://localhost:8082/doctors/1
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long doctorId, @RequestBody Doctor updatedDoctor){
        Doctor updateDoctor = doctorService.updateDoctor(doctorId, updatedDoctor);

        if (updateDoctor != null){
            return new ResponseEntity<>(updateDoctor, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete doctor service record by id
    // http://localhost:8082/doctors/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") long doctorId){
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor service record deleted successfully",HttpStatus.OK);
    }
}
