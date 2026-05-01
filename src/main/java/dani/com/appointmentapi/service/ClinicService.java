package dani.com.appointmentapi.service;

import dani.com.appointmentapi.dto.request.CreateClinicDTO;
import dani.com.appointmentapi.dto.request.UpdateClinicDTO;
import dani.com.appointmentapi.dto.res.ClinicResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ClinicService {
    void create(CreateClinicDTO clinicDTO);
    void update(UpdateClinicDTO clinicDTO, UUID clinicId);
    void deactivate(UUID clinicId);
    void activate(UUID clinicId);
    ClinicResponseDTO getClinicById(UUID clinicId);
    ClinicResponseDTO getClinicByCnpj(String cnpj);
    List<ClinicResponseDTO> getClinicByName(String name);
    List<ClinicResponseDTO> getAllClinics();
}
