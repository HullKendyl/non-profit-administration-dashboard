package org.NPAD;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

}
