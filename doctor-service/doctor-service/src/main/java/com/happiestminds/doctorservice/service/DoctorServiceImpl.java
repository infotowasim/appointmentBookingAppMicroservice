package com.happiestminds.doctorservice.service;

import com.happiestminds.doctorservice.entity.Doctor;
import com.happiestminds.doctorservice.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }


    // create doctor service record
    // http://localhost:8082/doctors
    @Override
    public Doctor saveDoctor(Doctor doctor) {
        Doctor saveDoctor = doctorRepository.save(doctor);
        return saveDoctor;
    }

    // get all doctor service record
    // http://localhost:8082/doctors
    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }


    // get doctor service record by id
    // http://localhost:8082/doctors/1
    @Override
    public Doctor getDoctorById(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(null);
        return doctor;
    }

    // update doctor service by id
    // http://localhost:8082/doctors/1
    @Override
    public Doctor updateDoctor(long doctorId, Doctor updatedDoctor) {

        Doctor doctor1 = doctorRepository.findById(doctorId).orElseThrow(null);

        if (doctor1 != null){
            doctor1.setName(updatedDoctor.getName());
            doctor1.setSpecialization(updatedDoctor.getSpecialization());
            Doctor updatedNewDoctor = doctorRepository.save(doctor1);
            return updatedNewDoctor;
        }
        return null;
    }

    // delete doctor service record by id
    // http://localhost:8082/doctors/1
    @Override
    public void deleteDoctor(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(null);
        doctorRepository.delete(doctor);
    }


}
