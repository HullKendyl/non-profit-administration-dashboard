package org.NPAD;

public class InvalidDonorEmailAddressException extends RuntimeException {
    public InvalidDonorEmailAddressException(String errorMessage) {
        super(errorMessage);
    }
}
