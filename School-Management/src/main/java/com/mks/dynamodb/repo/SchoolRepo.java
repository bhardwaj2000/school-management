package com.mks.dynamodb.repo;

import com.mks.dynamodb.entity.School;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
@EnableScan
public interface SchoolRepo extends CrudRepository<School,String> {
}
