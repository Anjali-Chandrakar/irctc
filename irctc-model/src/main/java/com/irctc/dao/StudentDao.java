package com.irctc.dao;

import org.springframework.stereotype.Repository;

import com.irctc.genericdao.CrudRepoGenericDao;
import com.irctc.model.Student;


@Repository
public interface StudentDao extends CrudRepoGenericDao<Student> {

}
