package com.example.pattern.DataConnectors.Service.impl;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.example.pattern.DataConnectors.Dto.BucketDto;
import com.example.pattern.DataConnectors.Service.AwsS3ServiceStub;
import com.example.pattern.DataConnectors.Service.Mapper.AwsS3Mapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AwsS3ServiceImpl implements AwsS3ServiceStub {

    public AmazonS3Client client = new AmazonS3Client();
    public AwsS3Mapper awsS3Mapper;
    public AwsS3ServiceImpl(AwsS3Mapper awsS3Mapper) {
        this.awsS3Mapper = awsS3Mapper;
    }
    @Override
    public List<Bucket> getAllBucket() {
        return client.listBuckets();
    }
    @Override
    public Bucket createBucket(final BucketDto dto) {
       final var bucket = awsS3Mapper.mappingBucket(dto);
        return client.createBucket(bucket.getName());
    }
    @Override
    public void deleteBucket(final BucketDto dto) {
         client.deleteBucket(awsS3Mapper.mappingBucket(dto).getName());
    }
}
