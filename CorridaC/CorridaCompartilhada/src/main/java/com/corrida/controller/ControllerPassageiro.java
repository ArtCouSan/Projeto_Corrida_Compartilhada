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

import com.corrida.entity.Passageiro;
import com.corrida.service.PassageiroService;

@Controller
@RequestMapping("/passageiro")
public class ControllerPassageiro {

	@Autowired
	private PassageiroService service;

	@GetMapping
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("passageiro").addObject("passageiro", new Passageiro());
		return modelAndView;

	}

	@PostMapping
	public ModelAndView add_update(@ModelAttribute(value = "passageiro") @Valid Passageiro passageiro,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("passageiro");
		}

		if (passageiro.getId() == null) {

			service.incluir(passageiro);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/passageiro");

		} else {

			service.alterar(passageiro);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/passageiro");

		}

	}

	@RequestMapping(value = "/procurar/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {

		Long idF = new Long(id);

		Passageiro passageiro = service.obter(idF);

		passageiro.setId(idF);

		service.alterar(passageiro);

		ModelAndView modelAndView = new ModelAndView("passageiro").addObject("passageiro", passageiro);
		return modelAndView;

	}

	@RequestMapping(value = "/consultarPassageiro")
	public ModelAndView searchAll() {

		ArrayList<Passageiro> passageiro = (ArrayList<Passageiro>) service.listar();

		ModelAndView modelAndView = new ModelAndView("consultaPassageiro").addObject("passageiros", passageiro);
		return modelAndView;

	}

}
