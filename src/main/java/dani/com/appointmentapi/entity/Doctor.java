package dani.com.appointmentapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "doctor_tb")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, unique = true, length = 6)
    private String crm;
    @Column(nullable = false, length = 11)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    private Boolean active = true;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorAvailability> availabilities;
}
