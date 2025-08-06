package edu.miu.cs.cs425.patientsappointmentsbookingapp.model;


import org.json.JSONObject;

import java.time.LocalDate;

public class Patient {
    private String firstName, lastName, contact, email, mailingAddress;
    private LocalDate dateOfBirth;

    public int getAge(){
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public Patient(String firstName, String lastName, String contact, String email, String mailingAddress, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.mailingAddress = mailingAddress;
        this.dateOfBirth = dateOfBirth;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("contact", contact);
        jsonObject.put("email", email);
        jsonObject.put("mailingAddress", mailingAddress);
        jsonObject.put("dateOfBirth", dateOfBirth);
        jsonObject.put("age", getAge());

        return jsonObject;
    }
}