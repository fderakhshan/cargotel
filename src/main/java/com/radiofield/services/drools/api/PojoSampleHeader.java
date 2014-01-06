package com.radiofield.services.drools.api;

import java.util.*;



/// THIS IS A DIRTY HACK...
/// Suggest we use JSR 303 bean validation annotations instead of this
/// class.
public class PojoSampleHeader {
    List headerDescription = new ArrayList();

    public PojoSampleHeader() {

        headerDescription.add(getVin());
        headerDescription.add(getTask());
        headerDescription.add(getDate());
    }

    public HashMap<String, String> getVin(){
        HashMap vinValidation= new HashMap<String, String>();
        vinValidation.put("is_required", true);

        HashMap vinDescription = new HashMap<String, String>();
        vinDescription.put("name", "vin");
        vinDescription.put("description", "the VIN for the vehicle");
        vinDescription.put("type", "string");
        vinDescription.put("validation", vinValidation);

        return vinDescription;
    }

    public HashMap<String, String> getTask(){
        HashMap taskValidation= new HashMap<String, String>();
        taskValidation.put("is_required", false);

        HashMap taskDescription = new HashMap<String, String>();
        taskDescription.put("name", "task");
        taskDescription.put("type", "string");
        taskDescription.put("description", "the task for the vehicle");
        taskDescription.put("validation", taskValidation);

        return taskDescription;
    }

    public HashMap<String, String> getDate(){
        HashMap dateValidation= new HashMap<String, String>();
        dateValidation.put("is_required", false);

        HashMap dateDescription = new HashMap<String, String>();
        dateDescription.put("name", "date");
        dateDescription.put("type", "date");
        dateDescription.put("description", "the date for the vehicle");
        dateDescription.put("validation", dateValidation);

        return dateDescription;
    }

    // i would probably define this as a complex object instead of a map
    public List<Map<String, Map<String, Object>>> getHeader(){
        return headerDescription;
    }
}
