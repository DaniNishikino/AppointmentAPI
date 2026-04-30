package dani.com.appointmentapi.dto.res;

import dani.com.appointmentapi.entity.Patient;

import java.time.LocalDate;
import java.util.UUID;

public record PatientResponseDTO(
        UUID id,
        String name,
        String cpf,
        LocalDate birthDate,
        String phone,
        String email,
        String address,
        Boolean active
) {
    public static PatientResponseDTO fromEntity(Patient p){
        return new PatientResponseDTO(
                p.getId(),
                p.getName(),
                p.getCpf(),
                p.getBirthDate(),
                p.getPhone(),
                p.getEmail(),
                p.getAddress(),
                p.getActive()
        );
    }
}
