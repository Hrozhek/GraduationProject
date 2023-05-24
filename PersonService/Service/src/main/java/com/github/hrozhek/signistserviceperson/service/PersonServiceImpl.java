package com.github.hrozhek.signistserviceperson.service;

import com.github.hrozhek.signistserviceperson.model.PersonEntity;
import com.github.hrozhek.signistserviceperson.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImpl implements PersonService {

    private final PersonRepo repo;

    @Override
    public List<PersonEntity> getPeople() {
        return repo.findAll(); //todo paging and where to map them
    }

    @Override
    public PersonEntity getPerson(long personId) {
        return repo.findById(personId).orElseThrow(IllegalArgumentException::new); //todo
    }

    //todo byName, byDoc etc...

    @Override
    public void deletePerson(long personId) {
        repo.deleteById(personId);
    }

    @Override
    public PersonEntity register(PersonEntity person) {
        return repo.save(person); //todo
    }

    @Override
    public PersonEntity update(long personId, PersonEntity person) {
        //todo check person before update
        PersonEntity updated = repo.findById(personId).orElseThrow(RuntimeException::new);//todo
        //todo update
        return repo.save(updated);
    }
}
