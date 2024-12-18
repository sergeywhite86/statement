package org.sergey_white.statement.dto;

import lombok.Data;
import org.sergey_white.statement.enums.EmploymentPosition;
import org.sergey_white.statement.enums.EmploymentStatus;


import java.math.BigDecimal;

@Data
public class EmploymentDto {
    private EmploymentStatus employmentStatus;
    private String employerINN;
    private BigDecimal salary;
    private EmploymentPosition position;
    private Integer workExperienceTotal;
    private Integer workExperienceCurrent;
}
