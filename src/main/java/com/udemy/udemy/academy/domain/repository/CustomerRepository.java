package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {

}
