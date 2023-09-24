package com.mks.dynamodb.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.mks.dynamodb.entity.Teacher;

public class TeacherCnovrter implements DynamoDBTypeConverter<String, Teacher> {
    @Override
    public String convert(Teacher teacher) {
        Teacher teacher1 = (Teacher) teacher;
        String teacherString = null;
        try{
            if(teacher1!=null){
                teacherString = String.format("%s x %s ",teacher1.getId(),teacher1.getTeacherName());
            }
        } catch (Exception ex){
            throw new RuntimeException("error in convert teacher to string :"+teacher,ex);
        }
        return teacherString;
    }

    @Override
    public Teacher unconvert(String s) {
        Teacher teacher = new Teacher();
        try {
            if(s!= null && s.length() !=0){
                String[] teacherString = s.split("x");
                teacher.setId(teacherString[0].trim());
                teacher.setTeacherName(teacherString[1].trim());

            }
        } catch (Exception ex){
            throw new RuntimeException("error in unconvert teacher"+s,ex);
        }
        return teacher;
    }
}
