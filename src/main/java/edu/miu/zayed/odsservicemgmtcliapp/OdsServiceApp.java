package edu.miu.zayed.odsservicemgmtcliapp;

import edu.miu.zayed.odsservicemgmtcliapp.service.AppointmentService;
import edu.miu.zayed.odsservicemgmtcliapp.util.JsonUtil;

public class OdsServiceApp {
    public static void main(String[] args) {
        // Example: Get Q1 2025 appointments
        int year = 2025;
        int quarter = 1;

        var appointments = new AppointmentService()
                .getAppointmentsByQuarter(year, quarter);

        if (appointments.isEmpty()) {
            System.out.println("No appointments found for Q" + quarter + " of " + year);
        } else {
            String jsonOutput = JsonUtil.convertToJson(appointments);
            System.out.println("Appointments for Q" + quarter + " " + year + ":");
            System.out.println(jsonOutput);
        }
    }
}