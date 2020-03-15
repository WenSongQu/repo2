package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.ESettledStatus;
import com.supergenius.admin.enums.EStatus;

import java.io.IOException;

public class SettledStatusSerialize  extends JsonSerializer<ESettledStatus> {
    @Override
    public void serialize(ESettledStatus eSettledStatus, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(eSettledStatus.getValue()==0){
            jsonGenerator.writeString("审核中");
            return;
        }
        if(eSettledStatus.getValue()==1){
            jsonGenerator.writeString("已入驻");
            return;
        }
        if(eSettledStatus.getValue()==2){
            jsonGenerator.writeString("已退出");
            return;
        }
        if(eSettledStatus.getValue()==3){
            jsonGenerator.writeString("未通过");
            return;
        }
    }
}
