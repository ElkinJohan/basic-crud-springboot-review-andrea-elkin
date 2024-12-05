package com.elkinandrea.repasoendpoint.enpointae.services;

import com.elkinandrea.repasoendpoint.enpointae.data.dto.PersonDto;
import com.elkinandrea.repasoendpoint.enpointae.data.payload.PersonForm;

import java.util.List;

public interface PersonService {
    PersonDto savePerson(PersonForm form);
    List<PersonDto> getAll();
    PersonDto update(Long id, PersonForm in);
    String delete(Long id);
}
