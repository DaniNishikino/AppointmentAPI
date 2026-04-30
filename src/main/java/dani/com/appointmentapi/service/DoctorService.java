package dani.com.appointmentapi.service;

import dani.com.appointmentapi.dto.request.CreateDoctorDTO;
import dani.com.appointmentapi.dto.request.UpdateDoctorDTO;
import dani.com.appointmentapi.dto.res.DoctorResponseDTO;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    void create(CreateDoctorDTO doctorDTO);
    void update(UpdateDoctorDTO doctorDTO, UUID doctorId);
    void deactivate(UUID doctorId);
    void activate(UUID doctorId);
    DoctorResponseDTO getDoctorById(UUID doctorId);
    DoctorResponseDTO getDoctorByCrm(String crm);
    DoctorResponseDTO getDoctorByEmail(String email);
    List<DoctorResponseDTO> getAllDoctors();

}
