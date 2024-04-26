package org.NPAD;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Donor {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

}
