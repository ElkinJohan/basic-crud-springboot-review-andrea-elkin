package com.elkinandrea.repasoendpoint.enpointae.repository;

import com.elkinandrea.repasoendpoint.enpointae.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
