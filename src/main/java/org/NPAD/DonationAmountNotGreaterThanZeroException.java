package org.NPAD;

public class DonationAmountNotGreaterThanZeroException extends RuntimeException {
    public DonationAmountNotGreaterThanZeroException(String errorMessage) {
        super(errorMessage);
    }
}
