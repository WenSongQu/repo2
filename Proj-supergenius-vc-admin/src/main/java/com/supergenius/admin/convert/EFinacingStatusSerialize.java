package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EFinacingStatus;
import com.supergenius.admin.enums.EOrder;

import java.io.IOException;

public class EFinacingStatusSerialize extends JsonSerializer<EFinacingStatus> {
    @Override
    public void serialize(EFinacingStatus eFinacingStatus, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (eFinacingStatus.getValue() == 0) {
            jsonGenerator.writeString("暂停融资");
            return;
        }
        if(eFinacingStatus.getValue()==1){
            jsonGenerator.writeString("完成融资");
            return;
        }

        if(eFinacingStatus.getValue()==3){
            jsonGenerator.writeString("融资中");
            return;
        }
        if (eFinacingStatus.getValue()==4){
            jsonGenerator.writeString("已冻结");
            return;
        }
        jsonGenerator.writeString("其他");
    }
}
