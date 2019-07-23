package com.irctc.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.service.TicketService;
import com.irctc.utils.Constants;
import com.irctc.vo.TicketVo;

@RestController
@RequestMapping(value = Constants.IRCTC_TICKET)
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@PostMapping(value = Constants.OPERATION_CREATE)
	public Map<String, Object> create(@RequestBody TicketVo ticketVo, Locale locale , Model model) {

		Map<String, Object> responseMap = ticketService.createTicket(ticketVo);
		return responseMap;
	}
	
	@GetMapping(value = Constants.OPERATION_READ)
	public Map<String, Object> read(@RequestBody  Map<String, Object> requestMap) {

		Integer id = new Integer(requestMap.get("id").toString());
		
		Map<String, Object> responseMap = ticketService.readTicket(id);
		return responseMap;
	}
	
	@PutMapping(value = Constants.OPERATION_UPDATE)
	public Map<String, Object> update(@RequestBody TicketVo ticketVo, Locale locale , Model model) {

		Map<String, Object> responseMap = ticketService.updateTicket(ticketVo);
		return responseMap;
	}
	
	@Transactional
	@DeleteMapping(value = Constants.OPERATION_DELETE)
	public Map<String, Object> delete(@RequestBody  Map<String, Object> requestMap, Locale locale , Model model) {

		Integer id = new Integer(requestMap.get("id").toString());

		Map<String, Object> responseMap = ticketService.deleteTicket(id);
		return responseMap;
	}
	
	@GetMapping(value = Constants.OPERATION_LIST)
	public List<TicketVo> listTicket() {

		List<TicketVo> ticketList = ticketService.listTicket();
		return ticketList;
	}
}
