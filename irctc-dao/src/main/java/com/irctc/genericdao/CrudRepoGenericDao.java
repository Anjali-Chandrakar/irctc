package com.irctc.genericdao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepoGenericDao<T extends Serializable> extends CrudRepository<T, Integer> {



}