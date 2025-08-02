package edu.miu.zayed.odsservicemgmtcliapp.repository;

import edu.miu.zayed.odsservicemgmtcliapp.domain.Appointment;
import edu.miu.zayed.odsservicemgmtcliapp.domain.Patient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class AppointmentRepository {
    private static Appointment[] appointments;
    private static AppointmentRepository instance;

    private AppointmentRepository() {
        loadData();
    }

    public static synchronized AppointmentRepository getInstance() {
        if (instance == null) {
            instance = new AppointmentRepository();
        }
        return instance;
    }

    private void loadData() {
        appointments = new Appointment[]{
                new Appointment(1L, LocalDate.of(2025, 2, 28), LocalTime.of(10, 5),
                        new Patient(1L, "John", "Smith", "(641) 001-1234", LocalDate.of(1987, 1, 19))),
                new Appointment(2L, LocalDate.of(2025, 3, 15), LocalTime.of(14, 30),
                        new Patient(2L, "Anna", "Jones", "(319) 716-1987", LocalDate.of(2001, 7, 26))),
                new Appointment(3L, LocalDate.of(2025, 1, 10), LocalTime.of(9, 0),
                        new Patient(3L, "Carlos", "Jimenez", "(319) 098-7711", LocalDate.of(1969, 11, 5)))
        };
    }

    public Appointment[] getAllAppointments() {
        return appointments;
    }
}
