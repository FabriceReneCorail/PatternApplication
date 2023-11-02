package com.example.pattern.DataConnectors.Controller;

import com.example.pattern.DataConnectors.Dto.BucketDto;
import com.example.pattern.DataConnectors.Service.AwsS3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/AWS/")
public class AwsS3Controller {
    AwsS3Service awsS3Service;
    @PostMapping("S3/createBucket")
    public ResponseEntity createBucket(@RequestBody BucketDto dto){
        awsS3Service.createBucket(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("S3/deleteBucket")
    public ResponseEntity deleteBucket(@RequestBody BucketDto dto){
        awsS3Service.deleteBucket(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("S3/GetAllBucket")
    public ResponseEntity getAllBucket(){
        awsS3Service.getAllBucket();
        return ResponseEntity.ok().build();
    }
}
