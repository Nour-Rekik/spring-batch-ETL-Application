package com.example.springbatch.data;

import com.example.springbatch.Models.doqtoor_admin_kpi.Practitioner;
import com.example.springbatch.Models.doqtoor_app.PractionnerInput;
import org.springframework.batch.item.ItemProcessor;

public class PractitionerDataProcessor implements ItemProcessor<PractionnerInput, Practitioner> {


    @Override
    public Practitioner process(final PractionnerInput practionnerInput) throws Exception {

        final String RegionExercise = practionnerInput.getExerciseRegion().toUpperCase();
        Practitioner practitioner = new Practitioner();
        practitioner.setId(practionnerInput.getId());
        practitioner.setRegionExercise(RegionExercise);
        practitioner.setRib(practionnerInput.getRib());
        practitioner.settaxRegistrationNumber(practionnerInput.getTaxRegistrationNumber());

        return practitioner;
    }

}
