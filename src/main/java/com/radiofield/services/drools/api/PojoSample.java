package com.radiofield.services.drools.api;

import java.util.*;
import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.RandomStringUtils;

public class PojoSample {
    public String vin;
    public String task;
    public Date date;

    public PojoSample(String _vin, String _task, Date _date){
        vin  = _vin;
        task = _task;
        date = _date;
    }

    @JsonIgnore
    public static List<PojoSample> createTest(int number){
        Random random = new Random();

        List<PojoSample> result = new ArrayList<PojoSample>();
        for(int i=0; i<number; i++){
            String vin =
                org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(14);

            String task = "a task " + random.nextInt();
            Date date = new Date();

            result.add(new PojoSample(vin, task, date));
        }

        return result;
    }
}
