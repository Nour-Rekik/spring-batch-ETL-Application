package com.example.springbatch.data;

import com.example.springbatch.Models.doqtoor_admin_kpi.Practitioner;
import com.example.springbatch.Models.doqtoor_app.PractitionerInput;
import org.springframework.batch.item.ItemProcessor;

public class PractitionerDataProcessor implements ItemProcessor<PractitionerInput, Practitioner> {


    @Override
    public Practitioner process(final PractitionerInput practitionerInput) throws Exception {

        final String RegionExercise = practitionerInput.getExerciseRegion().toUpperCase();
        Practitioner practitioner = new Practitioner();
        practitioner.setId(practitionerInput.getId());
        practitioner.setRegionExercise(RegionExercise);
        practitioner.setRib(practitionerInput.getRib());
        practitioner.settaxRegistrationNumber(practitionerInput.getTaxRegistrationNumber());

        return practitioner;
    }

}
