package edu.miu.zayed.odsservicemgmtcliapp.service;

import edu.miu.zayed.odsservicemgmtcliapp.domain.Appointment;
import edu.miu.zayed.odsservicemgmtcliapp.repository.AppointmentRepository;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService() {
        this.repository = AppointmentRepository.getInstance();
    }

    public List<Appointment> getAppointmentsByQuarter(int year, int quarter) {
        int startMonth = (quarter - 1) * 3 + 1; // Q1=1 (Jan), Q2=4 (Apr), etc.
        int endMonth = startMonth + 2;           // Q1=3 (Mar), Q2=6 (Jun), etc.

        return Arrays.stream(repository.getAllAppointments())
                .filter(a -> a.getDate().getYear() == year)
                .filter(a -> {
                    int monthValue = a.getDate().getMonthValue();
                    return monthValue >= startMonth && monthValue <= endMonth;
                })
                .sorted(Comparator.comparing(Appointment::getDate).reversed())
                .collect(Collectors.toList());
    }
}