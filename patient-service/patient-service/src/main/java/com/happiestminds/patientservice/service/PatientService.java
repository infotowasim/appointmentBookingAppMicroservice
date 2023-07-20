package com.happiestminds.patientservice.service;

import com.happiestminds.patientservice.entity.Patient;

import java.util.List;

public interface PatientService {

    // create patient service records

    Patient savePatient(Patient patient);

    // get all patient service records

    List<Patient> getAllPatients();

    // get patient service record by id

    Patient getPatientById(long patientId);

    // update patient service record by id

    Patient updatePatient(long patientId, Patient patient);

    // delete patient service record by id
    void deletePatient(long patientId);
}
