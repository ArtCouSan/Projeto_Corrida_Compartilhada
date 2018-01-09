package com.corrida.controller;

import javax.validation.Valid;

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

@Controller
@RequestMapping("/corrida")
public class ControllerCorrida {

	@GetMapping
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("corrida").addObject("corrida", new Corrida());
		return modelAndView;

	}

	@PostMapping
	public ModelAndView add_update(@ModelAttribute(value = "corrida") @Valid Corrida corrida, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("corrida");
		}

		if (corrida.getId() == null) {

			// service.incluir(formacao);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/corrida");

		} else {

			// service.alterar(formacao);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/corrida");

		}

	}

	@RequestMapping(value = "/procurar/{id}")
	public ModelAndView search(@PathVariable("id") String id) {

		Long idF = new Long(id);

		// Corrida corrida = service.obter(idF);
		//
		// corrida.setId(idF);
		//
		// service.alterar(corrida);
		//
		// ModelAndView modelAndView = new ModelAndView("corrida").addObject("corrida",
		// corrida);
		// return modelAndView;
		//

		return null;

	}

	@RequestMapping(value = "/consultarCorrida")
	public ModelAndView searchAll() {

		// ArrayList<Corrida> corrida = (ArrayList<Corrida>)
		// formacaoService.listar();
		//
		// ModelAndView modelAndView = new ModelAndView("consultarCorrida").addObject("corrida",
		// corrida);
		// return modelAndView;

		return null;

	}

}
