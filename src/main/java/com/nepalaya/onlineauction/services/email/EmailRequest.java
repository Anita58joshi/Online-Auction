package com.nepalaya.onlineauction.services.email;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class EmailRequest {
    String senderEmail = "basantaregmi2014@gmail.com";
    String password = "@Basanta1996";
    String subject;
    boolean auth = true;
    boolean sslEnable = true;
    String host = "smtp.gmail.com";
    String port = "465";
    String receiverEmail;
    String cc;
    String body;
    Map<String, String> dataMap;

}
