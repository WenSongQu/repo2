package com.supergenius.admin.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.supergenius.admin.enums.EOrder;
import com.supergenius.admin.enums.EOrderType;

import java.io.IOException;

public class EOrderTypeSerialize extends JsonSerializer<EOrderType> {
    @Override
    public void serialize(EOrderType order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (order.getValue() == 0) {
            jsonGenerator.writeString("会员订单");
            return;
        }
        if(order.getValue()==1){
            jsonGenerator.writeString("购买路演视频费");
            return;
        }
        if (order.getValue()==2){
            jsonGenerator.writeString("预约会议室付款");
            return;
        }
        if(order.getValue()==3){
            jsonGenerator.writeString("路演报名费");
            return;
        }
        if (order.getValue()==4){
            jsonGenerator.writeString("购买课程付款");
            return;
        }
        if(order.getValue()==5){
            jsonGenerator.writeString("保荐");
            return;
        }
        if (order.getValue()==6){
            jsonGenerator.writeString("推荐");
            return;
        }
        if (order.getValue()==7){
            jsonGenerator.writeString("召集");
            return;
        }
        jsonGenerator.writeString("其他");

    }
}
