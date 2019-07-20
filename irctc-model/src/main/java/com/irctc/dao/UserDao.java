package com.irctc.dao;

import org.springframework.stereotype.Repository;

import com.irctc.genericdao.CrudRepoGenericDao;
import com.irctc.model.User;

@Repository
public interface UserDao extends CrudRepoGenericDao<User> {

}
