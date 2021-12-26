package org.rising.star.repository;

import org.rising.star.model.StudentFeePaymentDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeePaymentRepository extends MongoRepository<StudentFeePaymentDetail , String> {
}
