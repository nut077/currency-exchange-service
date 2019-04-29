package com.github.nut077.microservice.currencyexchangeservice.controller;

import com.github.nut077.microservice.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        return new ExchangeValue(1L, from, to, BigDecimal.valueOf(65));
    }
}
