package dani.com.appointmentapi.controller;

import dani.com.appointmentapi.dto.request.CreatePatientDTO;
import dani.com.appointmentapi.dto.request.UpdatePatientDTO;
import dani.com.appointmentapi.dto.res.PatientResponseDTO;
import dani.com.appointmentapi.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;


    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }
    @GetMapping("/cpf")
    public ResponseEntity<PatientResponseDTO> getByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok(patientService.getPatientByCpf(cpf));
    }
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAll() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid @NotNull(message = "Patient is Null") CreatePatientDTO patient) {
        patientService.create(patient);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid @NotNull(message = "Patient is Null") UpdatePatientDTO patient, @PathVariable UUID id) {
        patientService.update(id, patient);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        patientService.deactivate(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable UUID id) {
        patientService.activate(id);
        return ResponseEntity.noContent().build();
    }

}
