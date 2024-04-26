package org.NPAD;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Donation {

    private Double amount;

    private String donationMessage;

    private DonationType donationType;

    private Donor donor;
}
