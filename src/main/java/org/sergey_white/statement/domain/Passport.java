package org.sergey_white.statement.domain;


import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Passport {
    private UUID id;
    private String series;
    private String number;
    private String issueBranch;
    private LocalDate issueDate;
    private Client client;
}
