package com.mks.dynamodb.controller;

import com.mks.dynamodb.entity.RQ.SchoolManagementRequest;
import com.mks.dynamodb.entity.RS.SchoolManagementResponse;
import com.mks.dynamodb.entity.School;
import com.mks.dynamodb.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<SchoolManagementResponse>> getSchoolService() {
        List<School> schools = schoolService.getSchool();
        List<SchoolManagementResponse> schoolManagementResponseList = new ArrayList<>();
        schools.forEach(school -> {
            schoolManagementResponseList.add(SchoolManagementResponse.entityToResponse(school));
        });
        return new ResponseEntity<>(schoolManagementResponseList, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<SchoolManagementResponse> saveSchool(@RequestBody SchoolManagementRequest schoolManagementRequest){
        School school = schoolManagementRequest.requestToEntity(schoolManagementRequest);
        School savedSchool = schoolService.saveSchool(school);
        return new ResponseEntity<>(SchoolManagementResponse.entityToResponse(savedSchool), HttpStatus.ACCEPTED);
    }

}
