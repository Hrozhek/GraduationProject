package com.github.hrozhek.signistserviceperson.service;

import com.github.hrozhek.signistserviceperson.repo.ModelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepo repo;

    @Override
    public Object getPersonModel(long personId) {
        return null;
    }

    @Override
    public Object addModel(long personId) {
        return null;
    }

    @Override
    public Object deleteModel(long personId) {
        return null;
    }
}
