package com.example.pattern.DataConnectors.Api.Controller;

import com.example.pattern.DataConnectors.Api.Dto.BucketDto;
import com.example.pattern.DataConnectors.Api.Service.AwsS3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsS3Controller {
    private AwsS3Service awsS3Service;
    public AwsS3Controller(final AwsS3Service awsS3Service){
        this.awsS3Service =  awsS3Service;
    }
    @PostMapping("/createBucket")
    public ResponseEntity createBucket(@RequestBody BucketDto dto){
        awsS3Service.createBucket(dto);
        return ResponseEntity.ok().build();
    }
}
