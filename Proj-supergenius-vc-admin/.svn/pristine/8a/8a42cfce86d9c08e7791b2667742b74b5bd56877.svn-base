package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EStatus;

import java.io.IOException;

/**
 * @author : zuoyu
 * @project : proj-supergenius-vc-admin
 * @description : 数据转换
 * @date : 2019-12-27 17:39
 **/
public class OrderStatusSerialize extends JsonSerializer<EStatus> {
    @Override
    public void serialize(EStatus eOrder, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (eOrder.getValue() == 0) {
            jsonGenerator.writeString("不需要");
            return;
        }
        if (eOrder.getValue() == 1) {
            jsonGenerator.writeString("需要");
            return;
        }
        jsonGenerator.writeString("未知");
    }
}
