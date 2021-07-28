package com.example.springbatch.data;

import com.example.springbatch.model.Practionner;
import org.springframework.batch.item.ItemProcessor;

import java.util.logging.Logger;

public class PractionnerDataProcessor implements ItemProcessor<PractionnerInput, Practionner> {


    @Override
    public Practionner process(final PractionnerInput practionnerInput) throws Exception {

        final String RegionExercise = practionnerInput.getExerciseRegion().toUpperCase();
        Practionner practionner = new Practionner();
        practionner.setId(practionnerInput.getId());
        practionner.setRegionExercise(RegionExercise);
        practionner.setRib(practionnerInput.getRib());
        practionner.settaxRegistrationNumber(practionnerInput.getTaxRegistrationNumber());

        return practionner;
    }

}
