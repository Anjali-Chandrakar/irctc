package com.irctc.dao;

import org.springframework.stereotype.Repository;

import com.irctc.genericdao.CrudRepoGenericDao;
import com.irctc.model.Schedule;

@Repository
public interface ScheduleDao extends CrudRepoGenericDao<Schedule> {

}
