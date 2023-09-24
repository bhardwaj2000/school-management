package com.mks.dynamodb.repo;

import com.mks.dynamodb.entity.Teacher;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface TeacherRepo extends CrudRepository<Teacher,String> {
}
