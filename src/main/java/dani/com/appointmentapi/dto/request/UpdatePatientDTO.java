package dani.com.appointmentapi.dto.request;

import dani.com.appointmentapi.entity.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdatePatientDTO(
        @Size(max = 100, message = "Name must be less than 100 characters")
        @NotBlank(message = "Name cannot be blank")
        String name,
        @Size(min = 10, max = 11, message = "Phone must be 10 or 11 digits")
        @NotBlank(message = "Phone cannot be blank")
        String phone,
        @Email(message = "Invalid email format")
        @NotBlank(message = "Email cannot be blank")
        String email,
        @NotBlank(message = "Address cannot be blank")
        String address
) {
    public void applyToEntity(Patient patient){
        patient.setName(name);
        patient.setPhone(phone);
        patient.setEmail(email);
        patient.setAddress(address);
    }
}
