package com.example.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatternApplication.class, args);
       /* final var builderImpl = new SourceException.BuilderImpl();
        final var owner = new Owner(builderImpl);
        final var bucket = new BucketDto();
        bucket.setName("testFRCBucket");
        bucket.setCreationDate(Date.from(Instant.EPOCH));
        bucket.setOwner(owner);*/
    }
}

