package com.cydeo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Currency {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }
}
