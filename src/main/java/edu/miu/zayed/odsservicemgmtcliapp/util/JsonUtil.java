package edu.miu.zayed.odsservicemgmtcliapp.util;

import edu.miu.zayed.odsservicemgmtcliapp.domain.Appointment;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

public class JsonUtil {
    public static String convertToJson(List<Appointment> appointments) {
        JSONArray jsonArray = new JSONArray();

        appointments.forEach(appt -> {
            JSONObject appointmentJson = new JSONObject();
            appointmentJson.put("appointmentId", appt.getId());
            appointmentJson.put("date", appt.getDate().toString());
            appointmentJson.put("time", appt.getTime().toString());

            JSONObject patientJson = new JSONObject();
            patientJson.put("patientId", appt.getPatient().getId());
            patientJson.put("firstName", appt.getPatient().getFirstName());
            patientJson.put("lastName", appt.getPatient().getLastName());
            patientJson.put("phoneNumber", appt.getPatient().getPhoneNumber());
            patientJson.put("dateOfBirth", appt.getPatient().getDateOfBirth().toString());

            appointmentJson.put("patient", patientJson);
            jsonArray.put(appointmentJson);
        });

        return jsonArray.toString(2); // Indent with 2 spaces
    }
}