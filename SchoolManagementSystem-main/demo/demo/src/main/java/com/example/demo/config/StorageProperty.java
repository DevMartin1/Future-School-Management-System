package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperty {
    private String uploadsLocation = "uploads/staff";

    public String getUploadsLocation() {
        return uploadsLocation;
    }

    public void setUploadsLocation(String uploadsLocation) {
        this.uploadsLocation = uploadsLocation;
    }
}
