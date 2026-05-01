package dani.com.appointmentapi.dto.res;

import dani.com.appointmentapi.entity.Clinic;

import java.util.UUID;

public record ClinicResponseDTO(
   UUID id,
   String name,
   String address,
   Boolean active
) {
    public static ClinicResponseDTO toDTO(Clinic c){
        return new ClinicResponseDTO(c.getId(), c.getName(), c.getAddress(), c.getActive());
    }
}
