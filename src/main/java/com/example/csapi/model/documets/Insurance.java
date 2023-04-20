package com.example.csapi.model.documets;

import com.example.csapi.model.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {

    private InsuranceType type;
    private CommercialGeneralAbility commecialGeneralAbility;
    private GeneralAggregateLimitAppliesPer generalAggregateLimit;
    private AutomobileLiability automobileLiability;
    private Liab liab;
    private DedRetention dedRetention;
    private WorkerCompensation workerCompensation;
}