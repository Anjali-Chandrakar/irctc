package com.irctc.dao;

import org.springframework.stereotype.Repository;

import com.irctc.genericdao.CrudRepoGenericDao;
import com.irctc.model.Ticket;

@Repository
public interface TicketDao extends CrudRepoGenericDao<Ticket> {

}
