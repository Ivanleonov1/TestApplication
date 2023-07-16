package com.example.testapplication.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "counter")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int value;
}
