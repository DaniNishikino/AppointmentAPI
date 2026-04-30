package dani.com.appointmentapi.service.impl;

import dani.com.appointmentapi.dto.request.CreateDoctorDTO;
import dani.com.appointmentapi.dto.request.UpdateDoctorDTO;
import dani.com.appointmentapi.dto.res.DoctorResponseDTO;
import dani.com.appointmentapi.entity.Doctor;
import dani.com.appointmentapi.repository.DoctorRepository;
import dani.com.appointmentapi.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public void create(CreateDoctorDTO doctorDTO) {
        if (doctorDTO == null){
            throw new IllegalArgumentException("Doctor is null");
        }
        doctorRepository.save(doctorDTO.createEntity());
    }

    @Override
    public void update(UpdateDoctorDTO doctorDTO, UUID doctorId) {
        if (doctorDTO == null){
            throw new IllegalArgumentException("Doctor is null");
        }
        Doctor doctorToUpdate = getDoctor(doctorId);
        doctorDTO.applyToEntity(doctorToUpdate);
        doctorRepository.save(doctorToUpdate);
    }

    @Override
    public void deactivate(UUID doctorId) {
        Doctor doctorToDeactivate = getDoctor(doctorId);
        doctorToDeactivate.setActive(false);
        doctorRepository.save(doctorToDeactivate);
    }

    @Override
    public void activate(UUID doctorId) {
        Doctor doctorToActivate = getDoctor(doctorId);
        doctorToActivate.setActive(true);
        doctorRepository.save(doctorToActivate);
    }

    @Override
    public DoctorResponseDTO getDoctorById(UUID doctorId) {
        return DoctorResponseDTO.toDTO(getDoctor(doctorId));
    }

    @Override
    public DoctorResponseDTO getDoctorByCrm(String crm) {
        return DoctorResponseDTO.toDTO(doctorRepository
                .getDoctorByCrm(crm)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found")));
    }

    @Override
    public DoctorResponseDTO getDoctorByEmail(String email) {
        return DoctorResponseDTO.toDTO(doctorRepository.getDoctorByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found")));
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll().stream().map(DoctorResponseDTO::toDTO).toList();
    }

    private Doctor getDoctor(UUID doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
    }



}
