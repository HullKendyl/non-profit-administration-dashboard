package org.NPAD;

public class InvalidDonorFirstNameException extends RuntimeException {
    public InvalidDonorFirstNameException(String errorMessage) {
        super(errorMessage);
    }
}
