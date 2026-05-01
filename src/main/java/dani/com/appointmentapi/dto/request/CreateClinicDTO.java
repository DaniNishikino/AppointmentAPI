package dani.com.appointmentapi.dto.request;

import dani.com.appointmentapi.entity.Clinic;

public record CreateClinicDTO(

        String name,
        String address
) {
    public Clinic createEntity(){
        Clinic clinic = new Clinic();
        clinic.setName(name);
        clinic.setAddress(address);
        return clinic;
    }
}
