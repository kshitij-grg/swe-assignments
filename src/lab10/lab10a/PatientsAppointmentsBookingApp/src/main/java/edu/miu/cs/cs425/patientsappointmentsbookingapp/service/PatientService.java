package edu.miu.cs.cs425.patientsappointmentsbookingapp.service;

import edu.miu.cs.cs425.patientsappointmentsbookingapp.model.Patient;
import edu.miu.cs.cs425.patientsappointmentsbookingapp.repository.PatientRepository;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public String convertCustomerToJSON() {
        Patient[] patients = patientRepository.getAllPatients();

        JSONArray jsonArray = new JSONArray();
        Arrays.stream(patients)
                .sorted(Comparator.comparing(Patient::getAge).reversed())
                .forEach(
                        patient -> jsonArray.put(patient.toJSON())
                );
        return jsonArray.toString(2);
    }
}
