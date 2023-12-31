package com.mks.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.mks.dynamodb.converter.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "student")
public class Student {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBTypeConverted(converter = DateConverter.class)
    @DynamoDBAttribute
    private Date registrationDate;

    @DynamoDBAttribute
    private String studentName;
}
