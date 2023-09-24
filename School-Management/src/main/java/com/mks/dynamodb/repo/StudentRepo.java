package com.mks.dynamodb.repo;

import com.mks.dynamodb.entity.Student;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
@EnableScan
public interface StudentRepo extends CrudRepository<Student, String> {
}
