package br.com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.example.model.Master;
import br.com.example.repository.MasterRepository;

@Component
public class MasterController {

	@Autowired
	private MasterRepository masterRepository;

	public Master save(Master master) {
		return masterRepository.save(master);
	}

	public List<Master> list() {
		return masterRepository.findAll();
	}

}
