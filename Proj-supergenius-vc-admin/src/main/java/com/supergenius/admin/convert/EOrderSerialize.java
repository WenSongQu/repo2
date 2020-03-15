package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EOrder;

import java.io.IOException;

public class EOrderSerialize extends JsonSerializer<EOrder> {
    @Override
    public void serialize(EOrder order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (order.getValue() == 0) {
            jsonGenerator.writeString("支付失败");
            return;
        }
        if(order.getValue()==1){
            jsonGenerator.writeString("支付成功");
            return;
        }
        if (order.getValue()==2){
            jsonGenerator.writeString("待支付状态");
            return;
        }
        if(order.getValue()==3){
            jsonGenerator.writeString("订单过期");
            return;
        }
        if (order.getValue()==4){
            jsonGenerator.writeString("取消订单");
            return;
        }
        if(order.getValue()==5){
            jsonGenerator.writeString("待退款");
            return;
        }
        if (order.getValue()==6){
            jsonGenerator.writeString("已退款");
            return;
        }
        jsonGenerator.writeString("其他");

    }
}
