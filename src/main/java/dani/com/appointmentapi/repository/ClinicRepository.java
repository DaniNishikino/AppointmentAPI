package dani.com.appointmentapi.repository;

import dani.com.appointmentapi.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClinicRepository extends JpaRepository<Clinic, UUID> {

    Optional<List<Clinic>> findByName(String name);
}
