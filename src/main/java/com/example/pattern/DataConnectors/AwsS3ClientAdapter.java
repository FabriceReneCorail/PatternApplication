package com.example.pattern.DataConnectors;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.example.pattern.DataConnectors.Dto.BucketDto;
import com.example.pattern.DataConnectors.Service.Mapper.AwsS3Mapper;
import java.util.List;

public class AwsS3ClientAdapter {
    private AmazonS3Client amazonS3Client;
    private AwsS3Mapper awsS3Mapper;
    public AwsS3ClientAdapter(AmazonS3Client amazonS3Client , AwsS3Mapper awsS3Mapper){
        this.amazonS3Client = amazonS3Client;
        this.awsS3Mapper = awsS3Mapper;
    }
    public List<Bucket> listBuckets() {
        return amazonS3Client.listBuckets();
    }

    public Bucket createBucket(final BucketDto dto) {
        final var bucket = awsS3Mapper.mappingBucket(dto);
        return amazonS3Client.createBucket(bucket.getName());
    }
    public void deleteBucket(final BucketDto dto) {
        amazonS3Client.deleteBucket(awsS3Mapper.mappingBucket(dto).getName());
    }
}
