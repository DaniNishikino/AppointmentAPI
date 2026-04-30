package dani.com.appointmentapi.dto.res;

import dani.com.appointmentapi.entity.Doctor;

import java.util.UUID;

public record DoctorResponseDTO(
        UUID id,
        String name,
        String crm,
        String phone,
        String email,
        Boolean active
) {
    public static DoctorResponseDTO toDTO(Doctor d){
        return new DoctorResponseDTO(
                d.getId(),
                d.getName(),
                d.getCrm(),
                d.getPhone(),
                d.getEmail(),
                d.getActive()
        );
    }
}
