package org.rising.star.repository;

import org.rising.star.model.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentEntity, String> {
//  List<StudentEntity> findByPublished(boolean published);
//  List<StudentEntity> findByTitleContaining(String title);
}
