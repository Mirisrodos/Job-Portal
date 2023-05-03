package com.oose.jobportal;

import com.cloudinary.Cloudinary;
import com.oose.jobportal.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class JobPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobPortalApplication.class, args);
    }

    @Bean
    public Cloudinary cloudinary() {
        // Configure
        Map config = new HashMap();
        config.put("cloud_name", "dteb1meav");
        config.put("api_key", "953488759223573");
        config.put("api_secret", "aTBBgA2RSo3_ey5sIieZxACWUoc");
        config.put("secure", true);
        Cloudinary cloudinary = new Cloudinary(config);

        return cloudinary;
    }
}
