package br.com.jccf.example.service.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jccf.example.controller.MasterController;
import br.com.jccf.example.model.Master;

@RestController
@RequestMapping("/master")
public class MasterRest {

	@Autowired
	private MasterController hospitalController;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Master save(@RequestBody Master master) {
		master.setId(UUID.randomUUID().toString());
		return hospitalController.save(master);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Master> list() {
		try {
			return hospitalController.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error on retrieve.");
		}
	}

}
