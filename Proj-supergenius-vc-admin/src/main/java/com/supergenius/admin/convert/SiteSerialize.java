package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.supergenius.admin.enums.EPayMethod;

import java.io.IOException;

public class SiteSerialize extends JsonSerializer<EPayMethod> {
    @Override
    public void serialize(EPayMethod ePayMethod, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (ePayMethod.getValue() == 0) {
            jsonGenerator.writeString("微信支付");
            return;
        }
        if(ePayMethod.getValue()==1){
            jsonGenerator.writeString("支付宝支付");
            return;
        }
        if (ePayMethod.getValue()==2){
            jsonGenerator.writeString("银联支付");
            return;
        }
        jsonGenerator.writeString("其他");

    }
}
