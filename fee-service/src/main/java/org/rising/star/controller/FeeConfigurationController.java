package org.rising.star.controller;

import org.rising.star.model.FeeType;
import org.rising.star.services.FeeConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FeeConfigurationController {


    private final FeeConfigurationService feeConfigurationService;

    public FeeConfigurationController(FeeConfigurationService feeConfigurationService) {
        this.feeConfigurationService = feeConfigurationService;
    }

    @PostMapping("/addFee")
    public void createFeeMaster(@RequestBody FeeType feeType){
        feeConfigurationService.createFeeMaster(feeType);

    }
    @GetMapping("/feeTypes")
    public ResponseEntity<List<FeeType>> getAllFeeTypes(@RequestParam(required = false) String title) {
        try {
            List<FeeType> feeTypes = new ArrayList<FeeType>();

            if (title == null)
                feeConfigurationService.findAll().forEach(feeTypes::add);
            else
           //     feeConfigurationService.findByTitleContaining(title).forEach(feeTypes::add);

            if (feeTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(feeTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/feeTypes/{id}")
    public ResponseEntity<FeeType> getFeeTypeById(@PathVariable("id") String id) {
        Optional<FeeType> feeTypeData = feeConfigurationService.findById(id);

        if (feeTypeData.isPresent()) {
            return new ResponseEntity<>(feeTypeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feeTypes/paymentMode")
    public ResponseEntity<List<FeeType>> findByPublished() {
        try {
            List<FeeType> feeTypes = feeConfigurationService.findByPaymentMode(true);

            if (feeTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(feeTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
