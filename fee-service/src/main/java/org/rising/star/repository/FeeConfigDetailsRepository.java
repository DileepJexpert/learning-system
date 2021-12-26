package org.rising.star.repository;

import org.rising.star.model.FeeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeeConfigDetailsRepository extends MongoRepository<FeeDetails,String> {
}
