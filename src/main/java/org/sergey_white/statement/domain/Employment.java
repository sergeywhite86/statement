package org.sergey_white.statement.domain;

import lombok.Data;
import org.sergey_white.statement.enums.EmploymentPosition;
import org.sergey_white.statement.enums.EmploymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Employment {
    private UUID id;
    private EmploymentStatus status;
    private String employerInn;
    private BigDecimal salary;
    private EmploymentPosition position;
    private Integer workExperienceTotal;
    private Integer workExperienceCurrent;
    private Client client;
}
