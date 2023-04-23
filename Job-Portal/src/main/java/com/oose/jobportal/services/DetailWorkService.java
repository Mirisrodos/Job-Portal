package com.oose.jobportal.services;

import com.oose.jobportal.models.entities.DetailWork;

import java.util.List;

public interface DetailWorkService {
    DetailWork findDetailWorkByID(int id);

    List<DetailWork> findAll();
}
