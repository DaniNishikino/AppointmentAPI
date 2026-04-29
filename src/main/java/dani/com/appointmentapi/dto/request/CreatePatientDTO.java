package dani.com.appointmentapi.dto.request;

import dani.com.appointmentapi.entity.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record CreatePatientDTO(
        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name must be less than 100 characters")
        String name,
        @NotBlank(message = "CPF is required")
        @Size(min = 11, max = 11, message = "CPF must be 11 digits")
        @CPF(message = "Invalid CPF format")
        String cpf,
        @NotNull(message = "Birth date is required")
        LocalDate birthDate,
        @NotBlank(message = "Phone is required")
        @Size(min = 10, max = 11, message = "Phone must be 10 or 11 digits")
        String phone,
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,
        String address
) {
        public Patient createEntity(){
                Patient patient = new Patient();
                patient.setName(name);
                patient.setCpf(cpf);
                patient.setBirthDate(birthDate);
                patient.setPhone(phone);
                patient.setEmail(email);
                patient.setAddress(address);
                return patient;
        }

}
