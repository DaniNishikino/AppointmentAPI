package dani.com.appointmentapi.dto.request;

import dani.com.appointmentapi.entity.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdatePatientDTO(
        @Size(max = 100, message = "Name must be less than 100 characters")
        String name,
        @Size(min = 10, max = 11, message = "Phone must be 10 or 11 digits")
        String phone,
        @Email(message = "Invalid email format")
        String email,
        String address
) {
    public void applyToEntity(Patient patient){
        if (patient.getName() != null) patient.setName(name);
        if (patient.getPhone() != null) patient.setPhone(phone);
        if (patient.getEmail() != null) patient.setEmail(email);
        if (patient.getAddress() != null) patient.setAddress(address);
    }
}
