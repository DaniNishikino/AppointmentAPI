package dani.com.appointmentapi.repository;

import dani.com.appointmentapi.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicRepository extends JpaRepository<Clinic, UUID> {
}
