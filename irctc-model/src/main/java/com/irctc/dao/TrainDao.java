package com.irctc.dao;

import org.springframework.stereotype.Repository;
import com.irctc.genericdao.CrudRepoGenericDao;
import com.irctc.model.Train;

@Repository
public interface TrainDao extends CrudRepoGenericDao<Train>{

}
