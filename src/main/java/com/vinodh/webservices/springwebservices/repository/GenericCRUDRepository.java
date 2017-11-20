package com.vinodh.webservices.springwebservices.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

public interface GenericCRUDRepository<T> extends CrudRepository<T, Serializable> {

}
