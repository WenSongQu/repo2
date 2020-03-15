package com.supergenius.admin.convert;

import com.alibaba.excel.converters.Converter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EIdentity;
import com.supergenius.admin.enums.EInvoiceHead;

import java.io.IOException;

public class IdentitySerialize extends JsonSerializer<EIdentity> {
    @Override
    public void serialize(EIdentity eIdentity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (eIdentity.getValue() == 1) {
            jsonGenerator.writeString("个人创业者");
            return;
        }
        if (eIdentity.getValue() == 2) {
            jsonGenerator.writeString("企业创业者");
            return;
        }
        if (eIdentity.getValue() == 3) {
            jsonGenerator.writeString("个人投资者");
            return;
        }
        if (eIdentity.getValue() == 4) {
            jsonGenerator.writeString("企业投资者");
            return;
        }
    }
}
