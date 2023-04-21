package com.oose.jobportal.models.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class WorkDto {
    private int workID;
    private Date date;
    private int income;
    private String location;
    private int quantity;
    private String workname;
    private int detailworkID;
    private int typeworkID;
}
