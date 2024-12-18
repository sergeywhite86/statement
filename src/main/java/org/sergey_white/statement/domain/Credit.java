package org.sergey_white.statement.domain;


import lombok.Data;
import org.sergey_white.statement.dto.PaymentScheduleElementDto;
import org.sergey_white.statement.enums.CreditStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class Credit {
    private UUID creditId;
    private BigDecimal amount;
    private int term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal psk;
    private List<PaymentScheduleElementDto> paymentSchedule;
    private boolean insuranceEnabled;
    private boolean salaryClient;
    private CreditStatus creditStatus;
    private Statement statement;
}
