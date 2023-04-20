package com.example.csapi.model.documets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    Coverages {
    private String policyNumber;

    /*The Extended Fund Facility (EFF) provides financial assistance to countries facing
     serious medium-term balance of payments problems because of structural weaknesses that
     require time to address.
     */
    private String policyEFF;
    private String policyEXP;
    private String limits;
}
