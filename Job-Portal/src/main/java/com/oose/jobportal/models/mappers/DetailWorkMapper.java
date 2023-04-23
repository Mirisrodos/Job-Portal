package com.oose.jobportal.models.mappers;

import com.oose.jobportal.models.dtos.DetailWorkDto;
import com.oose.jobportal.models.entities.DetailWork;
import com.oose.jobportal.models.entities.Work;

import java.util.ArrayList;
import java.util.List;

public class DetailWorkMapper {
    public static DetailWorkDto mappingToDto(DetailWork detailWork) {
        DetailWorkDto detailWorkDto = new DetailWorkDto();

        if (detailWork != null) {
            detailWorkDto.setDetailworkID(detailWork.getDetailworkID());
            detailWorkDto.setDescription(detailWork.getDescription());
            detailWorkDto.setHours(detailWork.getHours());
            detailWorkDto.setMoney(detailWork.getMoney());
            detailWorkDto.setPaymentID(detailWork.getPayment().getPaymentID());
            detailWorkDto.setContract(detailWork.getContract());
        } else {
            detailWorkDto.setDetailworkID(-1);
            detailWorkDto.setDescription("");
            detailWorkDto.setHours(0);
            detailWorkDto.setMoney(0);
            detailWorkDto.setPaymentID(-1);
            detailWorkDto.setContract("");
        }

        return detailWorkDto;
    }

    public static List<DetailWorkDto> mappingToListDto(List<DetailWork> detailWorkList) {
        List<DetailWorkDto> detailWorkDtoList = new ArrayList<>();

        if (detailWorkList == null)
        {
            detailWorkDtoList.add(mappingToDto(null));
            return detailWorkDtoList;
        }

        for(DetailWork detailWork : detailWorkList) {
            detailWorkDtoList.add(mappingToDto(detailWork));
        }

        return detailWorkDtoList;
    }
}
