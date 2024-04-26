package org.NPAD.controller;

import org.NPAD.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class DonationController {

    DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping(value = "/donation/add")
    public ResponseEntity<String> addDonation(@RequestBody Donation donation) {

        var isValid = false;
        var isSaved = false;

        try {
            isValid = donationService.validateDonation(donation);
        } catch (DonationAmountNotGreaterThanZeroException | InvalidDonorFirstNameException |
                 InvalidDonorLastNameException | InvalidDonorEmailAddressException | InvalidDonorPhoneNumberException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

        if (isValid) {
            try {
                isSaved = donationService.saveDonation(donation);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("");
            }
        }

        if (isSaved) {
            return ResponseEntity.ok().body("Donation saved successfully.");
        } return ResponseEntity.internalServerError().body("Donation failed to save.");
    }

}
