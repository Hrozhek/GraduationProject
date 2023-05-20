package com.github.hrozhek.signistserviceperson.service;

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
    public List<Object> getPeople() {
        return null;
//        return repo.findAll(); //todo paging and where to map them
    }

    @Override
    public Object getPerson(long personId) {
        return null;
    }

    //todo byName, byDoc etc...

    @Override
    public Object deletePerson(long personId) {
        return null;
    }

    @Override
    public Object register(Object person) {
        return null;
//                repo.save(person);
    }

    @Override
    public Object update(long personId, Object person) {
        return null;
//                repo.save(person);
    }
}
