package com.niit.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * @author 君已陌路
 * @date 2021/10/25 0:13
 * * 类名称: LongJsonDeserializer
 *  * 类描述: 将接收的前端字符串类型转换成Long类型
 */

//19位的字符串id数据转换成long类型时，由于位数太长丢失了精度，会将后几位用零代替，所以前端显示的就是丢失精度后的数据
//在我的项目里表现为orderID丢失精度
public class LongJsonDeserializer extends JsonDeserializer<Long> {
    private static final Logger logger = LoggerFactory.getLogger(LongJsonDeserializer.class);

    @Override
    public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        try {
            return value == null ? null : Long.parseLong(value);
        } catch (NumberFormatException e) {
            logger.error("数据转换异常", e);
            return null;
        }
    }
}

