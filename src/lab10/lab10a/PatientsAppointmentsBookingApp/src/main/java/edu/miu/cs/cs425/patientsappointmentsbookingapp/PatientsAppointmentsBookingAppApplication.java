package edu.miu.cs.cs425.patientsappointmentsbookingapp;

import edu.miu.cs.cs425.patientsappointmentsbookingapp.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientsAppointmentsBookingAppApplication implements CommandLineRunner {
    private final PatientService patientService;

    public PatientsAppointmentsBookingAppApplication(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to the Patient Service Application");
        var result = patientService.convertCustomerToJSON();
        System.out.println(result);
    }

    public static void main(String[] args) {
        SpringApplication.run(PatientsAppointmentsBookingAppApplication.class, args);
    }

}
