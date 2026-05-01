package dani.com.appointmentapi.service.impl;

import dani.com.appointmentapi.dto.request.CreateDoctorDTO;
import dani.com.appointmentapi.dto.request.UpdateDoctorDTO;
import dani.com.appointmentapi.dto.res.DoctorResponseDTO;
import dani.com.appointmentapi.entity.Doctor;
import dani.com.appointmentapi.repository.DoctorRepository;
import dani.com.appointmentapi.service.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public void create(CreateDoctorDTO doctorDTO) {
        doctorRepository.save(doctorDTO.createEntity());
    }

    @Override
    public void update(UpdateDoctorDTO doctorDTO, UUID doctorId) {
        Doctor doctorToUpdate = getDoctorByCrmOrThrow(doctorId);
        doctorDTO.applyToEntity(doctorToUpdate);
        doctorToUpdate.setUpdatedAt(LocalDateTime.now());
        doctorRepository.save(doctorToUpdate);
    }

    @Override
    public void deactivate(UUID doctorId) {
        Doctor doctorToDeactivate = getDoctorByCrmOrThrow(doctorId);
        doctorToDeactivate.setActive(false);
        doctorToDeactivate.setUpdatedAt(LocalDateTime.now());
        doctorRepository.save(doctorToDeactivate);
    }

    @Override
    public void activate(UUID doctorId) {
        Doctor doctorToActivate = getDoctorByCrmOrThrow(doctorId);
        doctorToActivate.setActive(true);
        doctorToActivate.setUpdatedAt(LocalDateTime.now());
        doctorRepository.save(doctorToActivate);
    }

    @Override
    public DoctorResponseDTO getDoctorById(UUID doctorId) {
        return DoctorResponseDTO.toDTO(getDoctorByCrmOrThrow(doctorId));
    }

    @Override
    public DoctorResponseDTO getDoctorByCrm(String crm) {
        return DoctorResponseDTO.toDTO(getDoctorByCrmOrThrow(crm));
    }

    @Override
    public DoctorResponseDTO getDoctorByEmail(String email) {
        return DoctorResponseDTO.toDTO(getDoctorByEmailOrThrow(email));
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll().stream().map(DoctorResponseDTO::toDTO).toList();
    }

    private Doctor getDoctorByCrmOrThrow(UUID doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }
    private Doctor getDoctorByCrmOrThrow(String crm){
        return doctorRepository.findByCrm(crm).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }
    private Doctor getDoctorByEmailOrThrow(String email){
        return doctorRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }




}
