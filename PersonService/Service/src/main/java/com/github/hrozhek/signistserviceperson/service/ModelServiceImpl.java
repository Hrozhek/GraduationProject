package com.github.hrozhek.signistserviceperson.service;

import com.github.hrozhek.signistservicepersondata.model.ModelEntity;
import com.github.hrozhek.signistserviceperson.repo.ModelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ModelServiceImpl implements ModelService {

    private final ModelRepo repo;

    @Override
    public ModelEntity getPersonModel(long personId) {
        return repo.findByPersonId(personId);
    }

    @Override
    public ModelEntity addModel(long personId) {
        ModelEntity model = new ModelEntity();
        model.setPersonId(personId);
        return repo.save(model);
    }

    @Override
    public void deleteModel(long modelId) {
        repo.deleteById(modelId);
    }
}
