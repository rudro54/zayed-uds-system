package edu.miu.zayed.odsservicemgmtcliapp.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Patient patient;

    // Constructors
    public Appointment() {}
    public Appointment(Long id, LocalDate date, LocalTime time, Patient patient) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.patient = patient;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", date=" + date +
                ", time=" + time + ", patient=" + patient + '}';
    }
}
