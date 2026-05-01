package dani.com.appointmentapi.dto.request;

import dani.com.appointmentapi.entity.Clinic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateClinicDTO(
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 100, message = "Name must not exceed 100 characters")
        String name,

        @NotBlank(message = "Address cannot be blank")
        @Size(max = 200, message = "Address must not exceed 200 characters")
        String address
) {
    public void applyToEntity(Clinic clinic){
        clinic.setName(name);
        clinic.setAddress(address);
    }
}
