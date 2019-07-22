package com.irctc.dao;

import org.springframework.stereotype.Repository;

import com.irctc.genericdao.CrudRepoGenericDao;
import com.irctc.model.Passenger;

@Repository
public interface PassengerDao extends CrudRepoGenericDao<Passenger> {

}
