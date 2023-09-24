package com.mks.dynamodb.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements DynamoDBTypeConverter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String convert(Date date) {
        return dateFormat.format(date);
    }

    @Override
    public Date unconvert(String s) {
        try{
            return dateFormat.parse(s);
        } catch (ParseException e){
            throw new RuntimeException("error in parse date"+s,e);
        }
    }
}
