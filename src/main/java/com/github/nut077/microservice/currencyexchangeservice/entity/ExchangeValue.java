package com.github.nut077.microservice.currencyexchangeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(name = "exchange_values_idx_currency_from_and_currency_to_unique", columnList = "currency_from,currency_to", unique = true)
})
@Entity(name = "exchange_values")
public class ExchangeValue {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigDecimal conversionMultiple;
    private int port;
}
