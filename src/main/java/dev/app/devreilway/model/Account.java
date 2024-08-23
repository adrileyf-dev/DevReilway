package dev.app.devreilway.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_acount")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true)
    private String number;
    @Column(nullable = false)
    private String agency;
    @Column(nullable = false , precision = 13,scale = 2)
    private BigDecimal balance;
    @Column(name = "adciionar_limit",nullable = true, precision = 13,scale = 2)

    private BigDecimal limit;
}


