package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EOrder;

import java.io.IOException;



public class OrderSerialize extends JsonSerializer<EOrder> {
    @Override
    public void serialize(EOrder eOrder, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(eOrder.getValue()==0){
            jsonGenerator.writeString("支付失败");
            return;
        }
        if(eOrder.getValue()==1){
            jsonGenerator.writeString("支付成功");
            return;
        }
        if(eOrder.getValue()==2){
            jsonGenerator.writeString("待支付状态");
            return;
        }
        if(eOrder.getValue()==3){
            jsonGenerator.writeString("订单过期");
            return;
        }
        if(eOrder.getValue()==4){
            jsonGenerator.writeString("取消订单");
            return;
        }
        if(eOrder.getValue()==5){
            jsonGenerator.writeString("待退款");
            return;
        }
        if(eOrder.getValue()==6){
            jsonGenerator.writeString("已退款");
            return;
        }
        jsonGenerator.writeString("其他");


    }
}
