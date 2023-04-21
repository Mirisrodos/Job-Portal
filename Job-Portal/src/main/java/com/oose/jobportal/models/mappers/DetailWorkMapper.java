package com.oose.jobportal.models.mappers;

import com.oose.jobportal.models.dtos.DetailWorkDto;
import com.oose.jobportal.models.entities.DetailWork;

public class DetailWorkMapper {
    public static DetailWorkDto mappingToDetailWorkDto(DetailWork detailWork) {
        DetailWorkDto detailWorkDto = new DetailWorkDto();

        if (detailWork != null) {
            detailWorkDto.setDetailworkID(detailWork.getDetailworkID());
            detailWorkDto.setDescription(detailWork.getDescription());
            detailWorkDto.setHours(detailWork.getHours());
            detailWorkDto.setMoney(detailWork.getMoney());
            detailWorkDto.setPaymentID(detailWork.getPayment().getPaymentID());
        } else {
            detailWorkDto.setDetailworkID(-1);
            detailWorkDto.setDescription("");
            detailWorkDto.setHours(0);
            detailWorkDto.setMoney(0);
            detailWorkDto.setPaymentID(-1);
        }

        return detailWorkDto;
    }
}
