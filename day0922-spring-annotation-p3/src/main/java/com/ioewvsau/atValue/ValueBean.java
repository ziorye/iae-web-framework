package com.ioewvsau.atValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValueBean {
    @Value("textFromValueAnnotation")
    private String text;
    @Value("${valueBean.description}")
    private String description;
    @Value("#{1+1}")
    private Integer order;
}
