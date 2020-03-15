package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EPayMethod;
import com.supergenius.admin.enums.EUsermode;

import java.io.IOException;

public class UsermodeSerialize extends JsonSerializer<EUsermode> {
    @Override
    public void serialize(EUsermode eUsermode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (eUsermode.getValue() == 0) {
            jsonGenerator.writeString("正常");
            return;
        }
        if (eUsermode.getValue() == 1) {
            jsonGenerator.writeString("已禁用");
            return;
        }
//        if (eUsermode.getValue() == 2) {
//            jsonGenerator.writeString("已到期");
//            return;
//        }
        jsonGenerator.writeString("其他");
    }
}
