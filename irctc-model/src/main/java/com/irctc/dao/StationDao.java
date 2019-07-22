package com.irctc.dao;

import org.springframework.stereotype.Repository;
import com.irctc.genericdao.CrudRepoGenericDao;
import com.irctc.model.Station;

@Repository
public interface StationDao extends CrudRepoGenericDao<Station>{

}
