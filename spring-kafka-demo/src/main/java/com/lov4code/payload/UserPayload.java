package com.lov4code.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserPayload {
    private Long id;
    private String name;
    private String mobileNumber;
}
