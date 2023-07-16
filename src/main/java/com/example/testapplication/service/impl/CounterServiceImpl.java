package com.example.testapplication.service.impl;

import com.example.testapplication.model.Counter;
import com.example.testapplication.repository.CounterRepository;
import com.example.testapplication.service.CounterService;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

    private final CounterRepository counterRepository;

    public CounterServiceImpl(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public int getCounterValue() {
        return counterRepository.findById(1L).orElse(new Counter()).getValue();
    }

    @Override
    public int incrementValue() {
        Counter counter = counterRepository.findById(1L).orElse(new Counter());
        counter.setValue(counter.getValue());
        counterRepository.save(counter);
        return 0;
    }

    @Override
    public Counter getCounter() {
        return new Counter();
    }
}
