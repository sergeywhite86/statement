package org.sergey_white.statement.domain;


import lombok.Data;
import org.sergey_white.statement.enums.ApplicationStatus;
import org.sergey_white.statement.enums.ChangeType;

import java.time.LocalDateTime;

@Data
public class StatusHistory {
    private ApplicationStatus status;
    private LocalDateTime time;
    private ChangeType changeType;
}
