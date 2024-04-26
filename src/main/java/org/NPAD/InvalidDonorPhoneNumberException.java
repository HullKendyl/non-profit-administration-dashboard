package org.NPAD;

public class InvalidDonorPhoneNumberException extends RuntimeException {
    public InvalidDonorPhoneNumberException(String errorMessage) {
        super(errorMessage);
    }
}