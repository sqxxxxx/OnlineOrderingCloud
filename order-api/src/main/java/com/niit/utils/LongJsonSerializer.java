package com.niit.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author 君已陌路
 * @date 2021/10/25 0:11
 *  * 类名称: LongJsonSerializer
 *  * 类描述: 向前端返回时将Long转成字符串
 */

//19位的字符串id数据转换成long类型时，由于位数太长丢失了精度，会将后几位用零代替，所以前端显示的就是丢失精度后的数据
    //在我的项目里表现为orderID丢失精度
public class LongJsonSerializer extends JsonSerializer<Long> {
    public void serialize(Long value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException, IOException {
        String text = (value == null ? null : String.valueOf(value));
        if (text != null) {
            jsonGenerator.writeString(text);
        }
    }
}
