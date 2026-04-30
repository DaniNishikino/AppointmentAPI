package dani.com.appointmentapi.repository;

import dani.com.appointmentapi.dto.res.DoctorResponseDTO;
import dani.com.appointmentapi.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Optional<Doctor> getDoctorByCrm(String crm);

    Optional<Doctor> getDoctorByEmail(String email);
}
