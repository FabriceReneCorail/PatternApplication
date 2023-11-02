package com.example.pattern.DataConnectors.Service.Mapper;

import com.amazonaws.services.s3.model.Bucket;
import com.example.pattern.DataConnectors.Dto.BucketDto;
import org.springframework.stereotype.Component;

@Component
public class AwsS3Mapper {
    public Bucket mappingBucket(final BucketDto dto){
        Bucket bucket = new Bucket();
        bucket.setName(dto.getName());
        bucket.setOwner(dto.getOwner());
        bucket.setCreationDate(dto.getCreationDate());
        return bucket;
    }
}
