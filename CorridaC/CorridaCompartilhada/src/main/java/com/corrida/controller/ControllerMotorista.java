package com.corrida.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.corrida.entity.Motorista;
import com.corrida.service.MotoristaService;

@Controller
@RequestMapping("/motorista")
public class ControllerMotorista {

	@Autowired
	private MotoristaService service;

	
	@GetMapping
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("motorista").addObject("motorista", new Motorista());
		return modelAndView;
		
	}

	@PostMapping
	public ModelAndView add_update(@ModelAttribute(value = "motorista") @Valid Motorista motorista, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("motorista");
		}
		
		if(motorista.getId() == null) {
			
			service.incluir(motorista);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/motorista");
			
		}else {
			
			service.alterar(motorista);
			
			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/motorista");
			
			
		}
		
	}
	
	@RequestMapping(value = "/procurar/{id}")
	public ModelAndView search(@PathVariable("id") String id) {
		
		Long idF = new Long(id);
		
		Motorista motorista = service.obter(idF);
		
		motorista.setId(idF);
		
		service.alterar(motorista);
		
		ModelAndView modelAndView = new ModelAndView("motorista").addObject("motorista", motorista);
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/consultarMotorista")
	public ModelAndView searchAll() {

		ArrayList<Motorista> motorista = (ArrayList<Motorista>)service.listar();
		
		 ModelAndView modelAndView = new ModelAndView("consultaMotorista").addObject("motoristas",
		motorista);
		 return modelAndView;



	}
	
}
