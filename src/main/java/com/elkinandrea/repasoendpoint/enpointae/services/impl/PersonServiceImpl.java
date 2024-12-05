package com.elkinandrea.repasoendpoint.enpointae.services.impl;

import com.elkinandrea.repasoendpoint.enpointae.data.dto.PersonDto;
import com.elkinandrea.repasoendpoint.enpointae.data.entity.Person;
import com.elkinandrea.repasoendpoint.enpointae.data.mapper.PersonMapper;
import com.elkinandrea.repasoendpoint.enpointae.data.payload.PersonForm;
import com.elkinandrea.repasoendpoint.enpointae.repository.PersonRepository;
import com.elkinandrea.repasoendpoint.enpointae.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    //atributos
    //inyectando el repositorio de persona
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDto savePerson(PersonForm form) {

        Person person = new Person();
        person.setName(form.getName());
        person.setAge(form.getAge());

        Person saved = this.personRepository.save(person);

        return this.personMapper.map(saved);
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = this.personRepository.findAll();
        List<PersonDto> dtoList = new ArrayList<>();

        for (Person myObjPerson : personList) {
            PersonDto persondto = this.personMapper.map(myObjPerson);
            dtoList.add(persondto);
        }
        return dtoList;
    }

    @Override
    public PersonDto update(Long id, PersonForm in) {
        //averiguamos si existe ese id en la BD
        Optional<Person> personById = this.personRepository.findById(id);

        //evaluamos si el contenido de la anterior consulta es vacio o no

        //si el id esta presente, entonces hacemos la logica de negocio
        if (personById.isPresent()) {

            //logicoa de negocio, es parecida al save

            //creamos una instancia de la entidad
            Person response = new Person();

            //le pasamos los datos a esa entidad, asi se reemplazara en la tabla

            //esta vez es necesario darle el id que ya existe, asi se actualizara, de lo contrario creara una entidad
            response.setId(personById.get().getId());

            //se le pasan los datos restantes que entraron, asi como en el save
            response.setName(in.getName());
            response.setAge(in.getAge());

            //se persiste en la BD y se retorna la entidad
            this.personRepository.save(response);
            return this.personMapper.map(response);
        }
        //si no esta presente osea false, entonces retorne un null
        return null;
    }

    @Override
    public String delete(Long id) {
        Optional<Person> optionalPerson = this.personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            this.personRepository.deleteById(optionalPerson.get().getId());
            return "Id:" + id + " fue Eliminado satisfactoriamente";
        }
        return "No existe o no se pudo eliminar";
    }
}
