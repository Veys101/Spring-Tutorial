package com.app.tutorial.springbootschoolwebawsdeploy.audit;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SchoolInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> schoolMap = new HashMap<String, String> ();
        schoolMap.put("App Name", "SchoolWeb");
        schoolMap.put("App Description", "School Web is a web application for Students and Admin");
        schoolMap.put("App Version", "1.0.0");
        schoolMap.put("Contact Email", "school@abc.com");
        schoolMap.put("Contact Mobile", "+1(12) 478 1232");
        builder.withDetail("schoolweb-info", schoolMap);


    }
}
