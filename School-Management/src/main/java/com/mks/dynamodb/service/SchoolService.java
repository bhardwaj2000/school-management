package com.mks.dynamodb.service;

import com.mks.dynamodb.entity.School;
import com.mks.dynamodb.repo.SchoolRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepo schoolRepo;

    public School saveSchool(School school){

        School save = schoolRepo.save(school);
        return save;
    }

    public List<School> getSchool(){
        Iterable<School> schools = schoolRepo.findAll();
        List<School> schoolList =  new ArrayList<>();
        schools.forEach(schoolList :: add);
        return schoolList;
    }
}
