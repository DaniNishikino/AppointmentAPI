package dani.com.appointmentapi.repository;

import dani.com.appointmentapi.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, UUID> {
}
