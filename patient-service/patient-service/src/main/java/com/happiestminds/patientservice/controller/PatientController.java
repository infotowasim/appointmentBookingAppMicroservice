package com.happiestminds.patientservice.controller;

import com.happiestminds.patientservice.entity.Patient;
import com.happiestminds.patientservice.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    // create patient service records
    // http://localhost:8081/api/patients
    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        Patient savePatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savePatient, HttpStatus.CREATED);
    }

    // get all patient service records
    // http://localhost:8081/api/patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patientList = patientService.getAllPatients();
        return ResponseEntity.ok(patientList);
    }

    // get patient service record by id
    // http://localhost:8081/api/patients/1
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long patientId){
        Patient patientById = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patientById);
    }

    // update patient service record by id
    // http://localhost:8081/api/patients/1
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable("id") long patientId){
        Patient updatedPatient = patientService.updatePatient(patientId, patient);
        return new ResponseEntity<>(updatedPatient,HttpStatus.CREATED);
    }

    // delete patient service record by id
    // http://localhost:8081/api/patient/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") long patientId){
        patientService.deletePatient(patientId);
        return ResponseEntity.ok("Patient record deleted successfully");
    }
}
