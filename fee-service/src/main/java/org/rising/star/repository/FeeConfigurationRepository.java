package org.rising.star.repository;

import org.rising.star.model.FeeType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeConfigurationRepository extends MongoRepository<FeeType ,String> {
    Iterable<Object> findByFeeType();

    List<FeeType> findByPaymentMode(boolean b);
}
