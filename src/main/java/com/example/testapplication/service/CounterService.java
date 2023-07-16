package com.example.testapplication.service;

import com.example.testapplication.model.Counter;

public interface CounterService {

    int getCounterValue();
    int incrementValue();

    Counter getCounter();
}
