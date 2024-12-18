package org.sergey_white.statement.domain;


import lombok.Data;
import org.sergey_white.statement.dto.LoanOfferDto;
import org.sergey_white.statement.enums.ApplicationStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Statement {
    private UUID statementId;
    private ApplicationStatus status;
    private LocalDateTime creationDate;
    private LoanOfferDto appliedOffer;
    private LocalDateTime signDate;
    private String sesCode;
    private List<StatusHistory> statusHistory;
    private Client client;
    private Credit credit;
}
