package dani.com.appointmentapi.controller;

import dani.com.appointmentapi.dto.request.CreateClinicDTO;
import dani.com.appointmentapi.dto.request.UpdateClinicDTO;
import dani.com.appointmentapi.dto.res.ClinicResponseDTO;
import dani.com.appointmentapi.service.ClinicService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clinic")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;

    @GetMapping
    public ResponseEntity<List<ClinicResponseDTO>> getAll() {

        return ResponseEntity.ok(clinicService.getAllClinics());
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<ClinicResponseDTO>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(clinicService.getClinicByName(name));
    }
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<ClinicResponseDTO> getByCnpj(@PathVariable String cnpj) {
        return ResponseEntity.ok(clinicService.getClinicByCnpj(cnpj));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClinicResponseDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(clinicService.getClinicById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid @NotNull(message = "Clinic cannot be null") CreateClinicDTO clinic) {
        clinicService.create(clinic);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid @NotNull(message = "Clinic cannot be null") UpdateClinicDTO clinic, @PathVariable UUID id) {
        clinicService.update(clinic, id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        clinicService.deactivate(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable UUID id) {
        clinicService.activate(id);
        return ResponseEntity.noContent().build();
    }

}
