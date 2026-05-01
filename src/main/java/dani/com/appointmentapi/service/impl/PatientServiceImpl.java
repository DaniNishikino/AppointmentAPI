package dani.com.appointmentapi.service.impl;


import dani.com.appointmentapi.dto.request.CreatePatientDTO;
import dani.com.appointmentapi.dto.request.UpdatePatientDTO;
import dani.com.appointmentapi.dto.res.PatientResponseDTO;
import dani.com.appointmentapi.entity.Patient;
import dani.com.appointmentapi.repository.PatientRepository;
import dani.com.appointmentapi.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public void create(CreatePatientDTO patient) {
        patientRepository.save(patient.createEntity());
    }

    @Override
    public void update(UUID patientId, UpdatePatientDTO patient) {
        Patient patientToUpdate = getPatient(patientId);
        patient.applyToEntity(patientToUpdate);
        patientToUpdate.setUpdatedAt(LocalDateTime.now());
        patientRepository.save(patientToUpdate);
    }

    @Override
    public void deactivate(UUID patientId) {
        Patient patientToDeactivate = getPatient(patientId);

        patientToDeactivate.setActive(false);
        patientToDeactivate.setUpdatedAt(LocalDateTime.now());
        patientRepository.save(patientToDeactivate);
    }

    @Override
    public void activate(UUID patientId) {
        Patient patientToActivate = getPatient(patientId);
        patientToActivate.setActive(true);
        patientToActivate.setUpdatedAt(LocalDateTime.now());
        patientRepository.save(patientToActivate);
    }

    @Override
    public PatientResponseDTO getPatientById(UUID id) {
        return PatientResponseDTO.fromEntity(getPatient(id));
    }

    @Override
    public PatientResponseDTO getPatientByCpf(String cpf) {
        return PatientResponseDTO.fromEntity(getPatient(cpf));
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(PatientResponseDTO::fromEntity).toList();
    }

    private Patient getPatient(UUID patientId) {
        return patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
    }
    private Patient getPatient(String cpf){
        return patientRepository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
    }

}
