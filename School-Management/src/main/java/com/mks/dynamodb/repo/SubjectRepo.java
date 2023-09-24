package com.mks.dynamodb.repo;

import com.mks.dynamodb.entity.Subject;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SubjectRepo extends CrudRepository<Subject,String>{
}
