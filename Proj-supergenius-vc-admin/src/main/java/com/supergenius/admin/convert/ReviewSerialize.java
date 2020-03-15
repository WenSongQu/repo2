package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EReview;
import com.supergenius.admin.enums.EUsermode;

import java.io.IOException;

public class ReviewSerialize extends JsonSerializer<EReview> {
    @Override
    public void serialize(EReview eReview, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (eReview.getValue() == 0) {
            jsonGenerator.writeString("未审查");
            return;
        }
        if (eReview.getValue() == 1) {
            jsonGenerator.writeString("已审查");
            return;
        }
        if (eReview.getValue() == 2) {
            jsonGenerator.writeString("审查中");
            return;
        }
        if (eReview.getValue() == 3) {
            jsonGenerator.writeString("通过");
            return;
        }
        if (eReview.getValue() == 4) {
            jsonGenerator.writeString("未通过");
            return;
        }
        jsonGenerator.writeString("其他");
    }
}
