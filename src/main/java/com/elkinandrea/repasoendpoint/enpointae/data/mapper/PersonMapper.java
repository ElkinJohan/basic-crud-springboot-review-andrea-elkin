package com.elkinandrea.repasoendpoint.enpointae.data.mapper;

import com.elkinandrea.repasoendpoint.enpointae.data.dto.PersonDto;
import com.elkinandrea.repasoendpoint.enpointae.data.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements IMapper<Person, PersonDto>{

    @Override
    public PersonDto map(Person in) {

        PersonDto persondto = new PersonDto();
        persondto.setName(in.getName());
        persondto.setAge(in.getAge());

        return persondto;
    }
}
