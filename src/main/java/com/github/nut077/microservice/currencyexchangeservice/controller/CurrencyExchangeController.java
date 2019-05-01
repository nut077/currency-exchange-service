package com.github.nut077.microservice.currencyexchangeservice.controller;

import com.github.nut077.microservice.currencyexchangeservice.entity.ExchangeValue;
import com.github.nut077.microservice.currencyexchangeservice.exception.NotFoundException;
import com.github.nut077.microservice.currencyexchangeservice.service.ExchangeValueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeValueService exchangeValueService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueService.exchangeValue(from, to);
        if (exchangeValue == null) {
            throw new NotFoundException("can't find from: " + from + " and to: " + to);
        }
        exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        log.info("{}", exchangeValue);
        return ResponseEntity.ok(exchangeValue);
    }
}
