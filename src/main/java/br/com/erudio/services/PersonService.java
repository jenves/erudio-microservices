package br.com.erudio.services;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person getPersonById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person personToBeUpdated) {

        Person entity = personRepository.findById(personToBeUpdated.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        entity.setAddress(personToBeUpdated.getAddress());
        entity.setGender(personToBeUpdated.getGender());
        entity.setFirstName(personToBeUpdated.getFirstName());
        entity.setLastName(personToBeUpdated.getLastName());

        return personRepository.save(personToBeUpdated);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}

//ctrl + alt + l = formata o código
