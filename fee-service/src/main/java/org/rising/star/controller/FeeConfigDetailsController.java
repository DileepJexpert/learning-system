package org.rising.star.controller;

import org.rising.star.model.FeeDetails;
import org.rising.star.repository.FeeConfigDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class FeeConfigDetailsController {

    private final FeeConfigDetailsRepository feeConfigDetailsRepository;

    public FeeConfigDetailsController(FeeConfigDetailsRepository feeConfigDetailsRepository) {
        this.feeConfigDetailsRepository = feeConfigDetailsRepository;
    }

    public ResponseEntity<FeeDetails> createFeeDetails(@RequestBody FeeDetails feeDetails){

                    FeeDetails _feeDetails        = this.feeConfigDetailsRepository.save( feeDetails);
                    return new ResponseEntity<>(_feeDetails, HttpStatus.CREATED);

    }

    public ResponseEntity< List<FeeDetails> > getFeeStructuresPage(){

                      List<FeeDetails> feeDetailsList =   this.feeConfigDetailsRepository.findAll();
        return new ResponseEntity<>(feeDetailsList, HttpStatus.CREATED);
    }
}
