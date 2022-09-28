package com.pluralsight.airportmanagement.db;

import com.pluralsight.airportmanagement.domain.Aircraft;
import org.springframework.core.convert.converter.Converter;

public class AircraftDbReadConverter implements Converter<String, Aircraft> {

    @Override
    public Aircraft convert(String source) {
        if(source == null){
            return null;
        }

        String[] parts = source.split("/");
        Aircraft aircraft = new Aircraft(parts[0], Integer.parseInt(parts[1]));
        return aircraft;
    }

}
