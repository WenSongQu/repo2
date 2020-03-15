package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EPayMethod;
import com.supergenius.admin.enums.EStatus;

import java.io.IOException;

public class SatausSerialize extends JsonSerializer<EStatus> {
    @Override
    public void serialize(EStatus eStatus, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (eStatus.getValue() == 0) {
            jsonGenerator.writeString("不可用");
            return;
        }
        if(eStatus.getValue()==1){
            jsonGenerator.writeString("可用");
            return;
        }
        if (eStatus.getValue()==2){
            jsonGenerator.writeString("亿删除");
            return;
        }
        jsonGenerator.writeString("其他");

    }
}