package com.example.pattern.DataConnectors.Api.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.example.pattern.DataConnectors.Api.Dto.BucketDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AwsS3Service {
    List<Bucket> getAllBucket();

    Bucket createBucket(BucketDto dto);

    void deleteBucket();
}
