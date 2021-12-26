package org.rising.star.services;

import org.rising.star.model.FeeType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FeeConfigurationService{
    public void createFeeMaster(FeeType feeType);

    List<FeeType> findAll();

    Iterable<Object> findByTitleContaining(String title);

    Optional<FeeType> findById(String id);

    List<FeeType> findByPaymentMode(boolean b);
}
