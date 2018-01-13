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

import com.corrida.entity.Corrida;
import com.corrida.entity.Motorista;
import com.corrida.entity.Passageiro;
import com.corrida.service.CorridaService;
import com.corrida.service.MotoristaService;
import com.corrida.service.PassageiroService;

@Controller
@RequestMapping("/corrida")
public class ControllerCorrida {

	@Autowired
	private CorridaService service;

	@Autowired
	private MotoristaService serviceMotoristas;

	@Autowired
	private PassageiroService servicePassageiros;

	@GetMapping
	public ModelAndView home() {

		ArrayList<Motorista> motoristas = (ArrayList<Motorista>) serviceMotoristas.listar();

		ArrayList<Passageiro> passageiros = (ArrayList<Passageiro>) servicePassageiros.listar();

		ModelAndView modelAndView = new ModelAndView("corrida").addObject("corrida", new Corrida())
				.addObject("passageiros", passageiros).addObject("motoristas", motoristas);
		return modelAndView;

	}

	@PostMapping
	public ModelAndView add_update(@ModelAttribute(value = "corrida") @Valid Corrida corrida, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("corrida");
		}

		if (corrida.getId() == null) {

			service.incluir(corrida);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/corrida");

		} else {

			service.alterar(corrida);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/corrida");

		}

	}

	@RequestMapping(value = "/procurar/{id}")
	public ModelAndView search(@PathVariable("id") String id) {

		Long idF = new Long(id);

		Corrida corrida = service.obter(idF);

		corrida.setId(idF);

		service.alterar(corrida);

		ModelAndView modelAndView = new ModelAndView("corrida").addObject("corrida", corrida);
		return modelAndView;

	}

	@RequestMapping(value = "/consultarCorrida")
	public ModelAndView searchAll() {

		ArrayList<Corrida> corrida = (ArrayList<Corrida>) service.listar();

		ArrayList<Passageiro> passageiro = (ArrayList<Passageiro>) servicePassageiros.listar();
		
		ArrayList<Motorista> motorista =  (ArrayList<Motorista>) serviceMotoristas.listar();
		
		ModelAndView modelAndView = new ModelAndView("consultaCorrida").addObject("corridas", corrida).addObject("passageiros", passageiro).addObject("motoristas", motorista);
		return modelAndView;

	}

}
