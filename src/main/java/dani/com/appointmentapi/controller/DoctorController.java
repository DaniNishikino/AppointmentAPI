package dani.com.appointmentapi.controller;

import dani.com.appointmentapi.dto.request.CreateDoctorDTO;
import dani.com.appointmentapi.dto.request.UpdateDoctorDTO;
import dani.com.appointmentapi.dto.res.DoctorResponseDTO;
import dani.com.appointmentapi.service.DoctorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;


    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAll() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }
    @GetMapping("/crm/{crm}")
    public ResponseEntity<DoctorResponseDTO> getByCrm(@PathVariable String crm) {
        return ResponseEntity.ok(doctorService.getDoctorByCrm(crm));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<DoctorResponseDTO> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(doctorService.getDoctorByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid @NotNull(message = "Doctor is Null") CreateDoctorDTO doctor) {
        doctorService.create(doctor);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid @NotNull(message = "Doctor Is Null") UpdateDoctorDTO doctor, @PathVariable UUID id) {
        doctorService.update(doctor,id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        doctorService.deactivate(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable UUID id) {
        doctorService.activate(id);
        return ResponseEntity.noContent().build();
    }


}
