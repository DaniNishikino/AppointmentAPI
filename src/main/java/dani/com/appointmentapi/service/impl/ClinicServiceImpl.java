package dani.com.appointmentapi.service.impl;

import dani.com.appointmentapi.dto.request.CreateClinicDTO;
import dani.com.appointmentapi.dto.request.UpdateClinicDTO;
import dani.com.appointmentapi.dto.res.ClinicResponseDTO;
import dani.com.appointmentapi.entity.Clinic;
import dani.com.appointmentapi.repository.ClinicRepository;
import dani.com.appointmentapi.service.ClinicService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;

    @Override
    public void create(CreateClinicDTO clinic) {
        clinicRepository.save(clinic.createEntity());

    }

    @Override
    public void update(UpdateClinicDTO clinicDTO, UUID clinicId) {
        Clinic clinic = getClinicOrThrow(clinicId);

        clinicDTO.applyToEntity(clinic);
        clinicRepository.save(clinic);
    }

    @Override
    public void deactivate(UUID clinicId) {
        Clinic clinic = getClinicOrThrow(clinicId);
        clinic.setActive(false);
        clinicRepository.save(clinic);
    }

    @Override
    public void activate(UUID clinicId) {
        Clinic clinic = getClinicOrThrow(clinicId);
        clinic.setActive(true);
        clinicRepository.save(clinic);   
    }

    @Override
    public ClinicResponseDTO getClinicById(UUID clinicId) {
        return ClinicResponseDTO.toDTO(getClinicOrThrow(clinicId));
    }

    @Override
    public ClinicResponseDTO getClinicByCnpj(String cnpj) {
        return ClinicResponseDTO.toDTO(getClinicByCnpjOrThrow(cnpj));
    }

    @Override
    public List<ClinicResponseDTO> getClinicByName(String name) {
        return getClinicByNameOrThrow(name).stream().map(ClinicResponseDTO::toDTO).toList();
    }

    @Override
    public List<ClinicResponseDTO> getAllClinics() {
        return clinicRepository.findAll().stream().map(ClinicResponseDTO::toDTO).toList();
    }


    private Clinic getClinicOrThrow(UUID clinicId) {
        return clinicRepository.findById(clinicId).orElseThrow(() -> new EntityNotFoundException("Clinic not found"));
    }
    private List<Clinic> getClinicByNameOrThrow(String name){
        return clinicRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Clinic not found"));
    }
    private Clinic getClinicByCnpjOrThrow(String cnpj){
        return clinicRepository.findByCnpj(cnpj).orElseThrow(() -> new EntityNotFoundException("Clinic not found"));
    }
}
