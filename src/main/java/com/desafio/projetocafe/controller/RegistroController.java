package com.desafio.projetocafe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.desafio.projetocafe.models.Registro;
import com.desafio.projetocafe.repository.RegistroRepository;

@Controller
public class RegistroController {

	@Autowired
	private RegistroRepository rere;
	
	
	@RequestMapping(value="/cadastroCafe", method=RequestMethod.GET)
	public String form() {
		
		return "cadastros/formRegistro";
		
	}
	
	@RequestMapping(value="/cadastroCafe", method=RequestMethod.POST)
	public String form(@Valid Registro cadastros) {
		
		List<Registro> dadosDoBanco = rere.cadastroselect(cadastros.getCpf(), cadastros.getItem());
		if(dadosDoBanco.isEmpty()) {
			
			rere.save(cadastros);


		}else {
			return "sdfsdf";
		}
		
		

		return "redirect:/cadastroCafe";
		
	}
	

	
	
	
	
	@RequestMapping("/registros")
	public ModelAndView ListaRegistros() {
		
		ModelAndView mv = new ModelAndView("index");
		Iterable<Registro> registros = rere.findAll();
		mv.addObject("cadastros", registros);
		return mv;
	}
	
}
