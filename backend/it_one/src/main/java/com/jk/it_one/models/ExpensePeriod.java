package com.jk.it_one.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jk.it_one.interfaces.WithBalanceValueAndStartDay;
import com.jk.it_one.enums.ExpenseKind;
import com.jk.it_one.enums.Period;
import com.jk.it_one.requestDtos.ExpensePeriodDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "expenses_period")
public class ExpensePeriod implements WithBalanceValueAndStartDay<ExpensePeriod> {
    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "balance_id", nullable = false)
    private Balance balance;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "kind", nullable = false)
    private ExpenseKind kind;

    @Column(name = "description")
    private String description;

    @Column(name = "date", nullable = false)
    private Date startDay;

    @Column(name = "period_value", nullable = false)
    private int periodValue;

    @Column(name = "period_kind", nullable = false)
    private Period periodKind;

    public ExpensePeriod() {
    }

    public ExpensePeriod(ExpensePeriodDto expencePeriodDto) {
        this.value = expencePeriodDto.getValue();
        this.kind = expencePeriodDto.getKind();
        this.description = expencePeriodDto.getDescription();
        this.startDay = expencePeriodDto.getStartDay();
        this.periodValue = expencePeriodDto.getPeriodValue();
        this.periodKind = expencePeriodDto.getPeriodKind();
    }
}