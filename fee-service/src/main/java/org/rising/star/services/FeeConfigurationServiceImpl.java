package org.rising.star.services;

import org.rising.star.model.FeeType;
import org.rising.star.repository.FeeConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeConfigurationServiceImpl implements FeeConfigurationService{

    private FeeConfigurationRepository feeConfigurationRepository;

    public FeeConfigurationServiceImpl(FeeConfigurationRepository feeConfigurationRepository) {
        this.feeConfigurationRepository = feeConfigurationRepository;
    }

    public void createFeeMaster(FeeType feeType){
        feeConfigurationRepository.save(feeType);

    }

    @Override
    public List<FeeType> findAll() {
        return feeConfigurationRepository.findAll();
    }

    @Override
    public Iterable<Object> findByTitleContaining(String title) {
        return feeConfigurationRepository.findByFeeType();
    }

    @Override
    public Optional<FeeType> findById(String id) {
        return feeConfigurationRepository.findById(id);
    }

    @Override
    public List<FeeType> findByPaymentMode(boolean b) {
        return feeConfigurationRepository.findByPaymentMode(b);
    }
}
