package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class AgeSerialize extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        try{
            Calendar cal = Calendar.getInstance();
            int i = cal.get(Calendar.YEAR);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            int birYear = instance.get(Calendar.YEAR);
            jsonGenerator.writeString( (i-birYear)+" ");
        }catch (Exception e){
            jsonGenerator.writeString(" ");
        }

    }
}
