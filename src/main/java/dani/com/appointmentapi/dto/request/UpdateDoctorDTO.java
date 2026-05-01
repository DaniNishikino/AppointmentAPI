package dani.com.appointmentapi.dto.request;

import dani.com.appointmentapi.entity.Doctor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateDoctorDTO(
        @Size(max = 100, message = "Name must be less than 100 characters")
        @NotBlank(message = "Name cannot be blank")
        String name,
        @Pattern(regexp = "^\\d{4,6}/[A-Z]{2}$", message = "Invalid CRM format.")
        @NotBlank(message = "CRM cannot be blank")
        String crm,
        @Size(min = 10, max = 11, message = "Phone must be 10 or 11 digits")
        @NotBlank(message = "Phone cannot be blank")
        String phone,
        @Email
        @NotBlank(message = "Email cannot be blank")
        String email
) {
    public void applyToEntity(Doctor doctor){
        doctor.setName(name);
        doctor.setCrm(crm);
        doctor.setPhone(phone);
        doctor.setEmail(email);
    }
}
