package com.example.pattern.DataConnectors.Service;

import com.amazonaws.services.s3.model.Bucket;
import com.example.pattern.DataConnectors.Dto.BucketDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AwsS3Service {
    List<Bucket> getAllBucket();

    Bucket createBucket(final BucketDto dto);

    void deleteBucket(final BucketDto dto);
}
