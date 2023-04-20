package com.example.csapi.repository;

import com.example.csapi.model.validations.LoadInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends MongoRepository<LoadInformation,String> {
}
