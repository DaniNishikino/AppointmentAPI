package dani.com.appointmentapi.dto.request;

import dani.com.appointmentapi.entity.Doctor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateDoctorDTO(
        @Size(max = 100, message = "Name must be less than 100 characters")
        String name,
        @Pattern(regexp = "^\\d{4,6}/[A-Z]{2}$", message = "Invalid CRM format.")
        String crm,
        @Size(min = 10, max = 11, message = "Phone must be 10 or 11 digits")
        String phone,
        @Email
        String email
) {
    public void applyToEntity(Doctor doctor){
        if (doctor.getName() != null) doctor.setName(name);
        if (doctor.getCrm() != null) doctor.setCrm(crm);
        if (doctor.getPhone() != null) doctor.setPhone(phone);
        if (doctor.getEmail() != null) doctor.setEmail(email);
    }
}
