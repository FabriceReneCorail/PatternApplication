package com.example.pattern.DataConnectors.Api.Dto;

import com.amazonaws.services.s3.model.Owner;
import java.util.Date;
import lombok.Data;

@Data
public class BucketDto {
    private static final long serialVersionUID = -8646831898339939580L;
    private String name = null;
    private Owner owner = null;
    private Date creationDate = null;
}

