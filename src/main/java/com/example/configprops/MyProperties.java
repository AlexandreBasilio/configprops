package com.example.configprops;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
//@Configuration
//@ConfigurationProperties(prefix = "my-properties")
public class MyProperties {

    private String host;
    private int port;
}
