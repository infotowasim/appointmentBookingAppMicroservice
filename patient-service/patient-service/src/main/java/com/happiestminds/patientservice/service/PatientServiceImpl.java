package com.happiestminds.patientservice.service;

import com.happiestminds.patientservice.entity.Patient;
import com.happiestminds.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;

    public PatientServiceImpl( PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    // create patient service records
    // http://localhost:8081/api/patients
    @Override
    public Patient savePatient(Patient patient) {
        Patient savePatient = patientRepository.save(patient);
        return savePatient;
    }

    // get all patient service records
    // http://localhost:8081/api/patients
    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList;
    }

    // get patient service record by id
    // http://localhost:8081/api/patients/1
    @Override
    public Patient getPatientById(long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(null);
        return patient;
    }

    // update patient service record by id
    // http://localhost:8081/api/patients/1
    @Override
    public Patient updatePatient(long patientId, Patient patient) {
        Patient patient1 = patientRepository.findById(patientId).orElseThrow(null);

        patient1.setName(patient.getName());
        patient1.setAge(patient.getAge());

        Patient updatedPatient = patientRepository.save(patient1);
        return updatedPatient;
    }

    // delete patient service record by id
    // http://localhost:8081/api/patient/1
    @Override
    public void deletePatient(long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(null);

        patientRepository.delete(patient);
    }
}
