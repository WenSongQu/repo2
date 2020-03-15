package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.ECapitalType;
import com.supergenius.admin.enums.EForm;

import java.io.IOException;

public class FormSerialize  extends JsonSerializer<EForm> {
    @Override
    public void serialize(EForm eForm, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (eForm.getValue() == 0) {
            jsonGenerator.writeString("公司制");
            return;
        }
        if (eForm.getValue() == 1) {
            jsonGenerator.writeString("有限合伙制");
            return;
        }
        if (eForm.getValue() == 2) {
            jsonGenerator.writeString("信托制");
            return;
        }
    }
}
