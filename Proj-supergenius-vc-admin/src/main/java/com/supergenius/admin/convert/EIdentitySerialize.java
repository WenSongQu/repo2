package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EIdentity;
import com.supergenius.admin.enums.EOrder;

import java.io.IOException;

public class EIdentitySerialize extends JsonSerializer<EIdentity> {
    @Override
    public void serialize(EIdentity order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(order.getValue()==1){
            jsonGenerator.writeString("个人创业者");
            return;
        }
        if (order.getValue()==2){
            jsonGenerator.writeString("企业创业者");
            return;
        }
        if(order.getValue()==3){
            jsonGenerator.writeString("个人投资者");
            return;
        }
        if (order.getValue()==4){
            jsonGenerator.writeString("机构投资者");
            return;
        }

        jsonGenerator.writeString("其他");

    }
}
