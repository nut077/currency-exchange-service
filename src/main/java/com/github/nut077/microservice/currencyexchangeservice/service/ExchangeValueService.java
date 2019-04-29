package com.github.nut077.microservice.currencyexchangeservice.service;

import com.github.nut077.microservice.currencyexchangeservice.entity.ExchangeValue;
import com.github.nut077.microservice.currencyexchangeservice.repository.ExchangeValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExchangeValueService {

    private final ExchangeValueRepository exchangeValueRepository;

    public ExchangeValue exchangeValue(String from, String to) {
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
