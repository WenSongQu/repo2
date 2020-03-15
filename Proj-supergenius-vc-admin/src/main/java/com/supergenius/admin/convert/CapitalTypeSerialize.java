package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.ECapitalType;
import com.supergenius.admin.enums.EIdentity;

import java.io.IOException;

public class CapitalTypeSerialize  extends JsonSerializer<ECapitalType> {
    @Override
    public void serialize(ECapitalType eCapitalType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (eCapitalType.getValue() == 0) {
            jsonGenerator.writeString("中资（国有背景）");
            return;
        }
        if (eCapitalType.getValue() == 1) {
            jsonGenerator.writeString("中资（非国有背景）");
            return;
        }
        if (eCapitalType.getValue() == 2) {
            jsonGenerator.writeString("外资");
            return;
        }
        if (eCapitalType.getValue() == 3) {
            jsonGenerator.writeString("中外资（国有背景）");
            return;
        }
        if (eCapitalType.getValue() == 4) {
            jsonGenerator.writeString("中外资（非国有背景）");
            return;
        }
    }
}
