package com.irctc.service;

import java.util.List;
import java.util.Map;

import com.irctc.vo.TicketVo;

public interface TicketService {
	Map<String, Object> createTicket(TicketVo ticketVo);
	Map<String, Object> readTicket(Integer id);
	Map<String, Object> updateTicket(TicketVo ticketVo);
	Map<String, Object> deleteTicket(Integer id);
	List<TicketVo> listTicket();
}
