package org.sergey_white.statement.domain;



import lombok.Data;
import org.sergey_white.statement.enums.Gender;
import org.sergey_white.statement.enums.MaritalStatus;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Client {
    private UUID client_Id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String email;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private Integer dependentAmount;
    private Passport passport;
    private Employment employment;
    private String accountNumber;
    private Statement statement;
}