package com.happiestminds.doctorservice.service;

import com.happiestminds.doctorservice.entity.Doctor;

import java.util.List;

public interface DoctorService {

    // create doctor service record

    Doctor saveDoctor(Doctor doctor);

    // get all doctor service record

    List<Doctor> getAllDoctors();

    // get doctor service record by id

    Doctor getDoctorById(long doctorId);

    // update doctor service by id
    Doctor updateDoctor(long doctorId, Doctor updatedDoctor);

    // delete doctor service record by id
    void deleteDoctor(long doctorId);
}
