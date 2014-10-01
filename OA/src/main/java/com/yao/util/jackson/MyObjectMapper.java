package com.yao.util.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;

/**
 *
 * @author yao
 */
public class MyObjectMapper extends ObjectMapper {
    public MyObjectMapper() {
        super();
        this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}
