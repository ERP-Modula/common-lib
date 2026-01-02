package com.modula.common.domain.billing.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteOperationCommand {
    private UUID userId;
    private String operationKey;
    private String referenceId;
    private String description;
}