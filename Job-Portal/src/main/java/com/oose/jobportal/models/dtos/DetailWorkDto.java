package com.oose.jobportal.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class DetailWorkDto {
    private int detailworkID;
    private String description;
    private int hours;
    private int money;
    private int paymentID;
    private String contract;
}
