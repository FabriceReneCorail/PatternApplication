package com.example.pattern.DataConnectors.Api.Service.impl;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.example.pattern.DataConnectors.Api.Dto.BucketDto;
import com.example.pattern.DataConnectors.Api.Service.AwsS3Service;
import com.example.pattern.DataConnectors.Api.Service.Mapper.AwsS3Mapper;
import java.util.List;

public class AwsS3ServiceImpl implements AwsS3Service {

    private AmazonS3Client client;
    private AwsS3Mapper awsS3Mapper;
    public AwsS3ServiceImpl(AmazonS3Client client, AwsS3Mapper awsS3Mapper) {
        this.client = client;
        this.awsS3Mapper = awsS3Mapper;
    }
    @Override
    public List<Bucket> getAllBucket() {
        return client.listBuckets();
    }

    @Override
    public Bucket createBucket(BucketDto dto) {
       final var bucket = awsS3Mapper.mappingBucket(dto);
        client.createBucket(bucket.getName());
        // miss region ?
        return null;
    }

    @Override
    public void deleteBucket() {

    }
}
