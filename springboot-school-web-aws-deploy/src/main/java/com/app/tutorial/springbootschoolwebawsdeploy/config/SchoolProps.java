package com.app.tutorial.springbootschoolwebawsdeploy.config;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component("schoolProps")
@Data
@ConfigurationProperties(prefix = "school")
@Validated
public class SchoolProps {

    @Min(value = 5, message = "must be between 5 to 25")
    @Max(value = 25, message = "must be between 5 to 25")
    private int defaultPageSize;
    private Map<String, String> contact;
    private List<String> branches;

}
