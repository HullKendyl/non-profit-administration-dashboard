package org.NPAD;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class DonationService {

    DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public boolean saveDonation(Donation donation) {

        final var donationAmount = donation.getAmount();
        final var donationTime = LocalDateTime.now();
        final var donor = donation.getDonor();
        final var donorFirstName = donor.getFirstName();
        final var donorLastName = donor.getLastName();
        final var donorFullName = donorFirstName + " " + donorLastName;
        final var donationMessage = donation.getDonationMessage();
        final var donationType = donation.getDonationType().getDonationType();

        final var donationDTO = DonationDTO.builder()
                .amount(Double.valueOf(donationAmount))
                .dateTime(donationTime)
                .primaryDonorFullName(donorFullName)
                .donationMessage(donationMessage)
                .donationType(donationType)
                .build();

        try {
            donationRepository.save(donationDTO);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean validateDonation(Donation donation) {

        try {
            validateAmount(donation.getAmount());
        } catch (DonationAmountNotGreaterThanZeroException exception) {
            throw new DonationAmountNotGreaterThanZeroException("Invalid Data - The donation amount is not greater than zero.");
        }

        try {
            validateDonor(donation.getDonor());
        } catch (InvalidDonorFirstNameException exception) {
            throw new InvalidDonorFirstNameException("Invalid Data - Donor First Name not provided.");
        } catch (InvalidDonorLastNameException exception) {
            throw new InvalidDonorLastNameException("Invalid Data - Donor Last Name not provided.");
        } catch (InvalidDonorEmailAddressException exception) {
            throw new InvalidDonorEmailAddressException("Invalid Data - Donor Email Address not provided.");
        } catch (InvalidDonorPhoneNumberException exception) {
            throw new InvalidDonorPhoneNumberException("Invalid Data - Donor Phone Number not provided.");
        }

        // TODO - validate donation type

        return true;
    }

    public boolean validateDonor(Donor donor) {

        if (donor == null) {
            return false;
        }

        // TODO - validate strings for length and formatting
        if (donor.getFirstName().isBlank()) {
            throw new InvalidDonorFirstNameException("Invalid Data - Donor First Name not provided.");
        }
        if (donor.getLastName().isBlank()) {
            throw new InvalidDonorLastNameException("Invalid Data - Donor Last Name not provided.");
        }
        if (donor.getEmailAddress().isBlank()) {
            throw new InvalidDonorEmailAddressException("Invalid Data - Donor Email Address not provided.");
        }
        if (donor.getPhoneNumber().isBlank()) {
            throw new InvalidDonorPhoneNumberException("Invalid Data - Donor Phone Number not provided.");
        }

        return true;

    }

    public boolean validateAmount(Double donationAmount) {

        if(donationAmount <= 0.00) {
            throw new DonationAmountNotGreaterThanZeroException("Invalid Data - The donation amount is not greater than zero.");
        }

        return true;
    }
}
