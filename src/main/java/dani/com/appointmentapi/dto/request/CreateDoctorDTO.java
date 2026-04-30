package dani.com.appointmentapi.dto.request;

import dani.com.appointmentapi.entity.Doctor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateDoctorDTO(
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    String name,
    @NotBlank(message = "CRM is required")
    @Pattern(regexp = "^\\d{4,6}/[A-Z]{2}$", message = "Invalid CRM format.")
    String crm,
    @NotBlank(message = "Phone is required")
    @Size(min = 10, max = 11, message = "Phone must be 10 or 11 digits")
    String phone,
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email
) {
    public Doctor createEntity(){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setCrm(crm);
        doctor.setPhone(phone);
        doctor.setEmail(email);
        return doctor;
    }
}
