package dani.com.appointmentapi.service;

import dani.com.appointmentapi.dto.request.CreatePatientDTO;
import dani.com.appointmentapi.dto.request.UpdatePatientDTO;
import dani.com.appointmentapi.dto.res.PatientResponseDTO;

import java.util.List;
import java.util.UUID;


public interface PatientService {
    void create(CreatePatientDTO patient);
    void update(UUID patientId, UpdatePatientDTO patient);
    void deactivate(UUID patientId);
    void activate(UUID patientId);
    PatientResponseDTO getPatientById(UUID patientId);
    PatientResponseDTO getPatientByCpf(String cpf);
    List<PatientResponseDTO> getAllPatients();
}
