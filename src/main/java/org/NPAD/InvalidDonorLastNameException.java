package org.NPAD;

public class InvalidDonorLastNameException extends RuntimeException{
    public InvalidDonorLastNameException(String errorMessage) {
        super(errorMessage);
    }
}
