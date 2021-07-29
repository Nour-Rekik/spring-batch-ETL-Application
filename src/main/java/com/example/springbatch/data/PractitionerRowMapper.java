package com.example.springbatch.data;

import com.example.springbatch.Models.doqtoor_admin_kpi.Practitioner;
import com.example.springbatch.Models.doqtoor_app.PractitionerInput;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PractitionerRowMapper implements RowMapper<PractitionerInput> {

    @Override
    public PractitionerInput mapRow(ResultSet rs, int rowNum) throws SQLException {
        PractitionerInput person = new PractitionerInput();

        person.setExerciseRegion(rs.getString("exercise_region"));
        person.setRib(rs.getString("rib"));
        person.setTaxRegistrationNumber(rs.getString("tax_registration_number"));
        person.setAvailability(rs.getBoolean("availability"));
        person.setCin(rs.getString("cin"));
        person.setAvailabilityHoursDescription(rs.getString("availability_hours_description"));
        person.setConsultationPrice(rs.getDouble("consultation_price"));
        person.setNationalId(rs.getString("national_id"));
        person.setPresentation(rs.getString("presentation"));
        person.setSpeciality(rs.getString("speciality"));
        person.setTitle(rs.getString("title"));



        return person;
    }

}
