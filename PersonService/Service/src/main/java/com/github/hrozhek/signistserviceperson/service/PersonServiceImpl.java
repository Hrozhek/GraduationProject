package com.github.hrozhek.signistserviceperson.service;

import com.github.hrozhek.signistservicepersondata.model.PersonEntity;
import com.github.hrozhek.signistserviceperson.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepo repo;

    //todo если нужно смаппить, маппим здесь скорее всего

    @Override
    public List<PersonEntity> getPeople() {
        return null;
//        return repo.findAll(); //todo paging and where to map them
    }

    @Override
    public PersonEntity getPerson(long personId) {
        return null;
    }

    //todo byName, byDoc etc...

    @Override
    public PersonEntity deletePerson(long personId) {
        return null;
    }

    @Override
    public PersonEntity register(PersonEntity person) {
        return null;
//                repo.save(person);
    }

    @Override
    public PersonEntity update(long personId, PersonEntity person) {
        //todo check person before update
        PersonEntity updated = repo.findById(personId).orElseThrow(RuntimeException::new);//todo
        //todo update
        return repo.save(updated);
    }
}
