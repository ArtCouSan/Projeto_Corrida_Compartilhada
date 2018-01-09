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

import com.corrida.entity.Passageiro;

@Controller
@RequestMapping("/passageiro")
public class ControllerPassageiro {


	@GetMapping
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("passageiro").addObject("passageiro", new Passageiro());
		return modelAndView;
		
	}

	@PostMapping
	public ModelAndView add_update(@ModelAttribute(value = "passageiro") @Valid Passageiro passageiro, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("passageiro");
		}
		
		if(passageiro.getId() == null) {
			
//			service.incluir(formacao);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/passageiro");
			
		}else {
			
//			service.alterar(formacao);
			
			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/passageiro");
			
			
		}
		
	}
	
	@RequestMapping(value = "/procurar/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
		
		Long idF = new Long(id);
		
//		Passageiro passageiro = service.obter(idF);
//		
//		passageiro.setId(idF);
//		
//		service.alterar(passageiro);
//		
//		ModelAndView modelAndView = new ModelAndView("passageiro").addObject("passageiro", passageiro);
//		return modelAndView;
//		
		
		return null;
		
	}
	
	@RequestMapping(value = "/consultarPassageiro")
	public ModelAndView searchAll() {

		// ArrayList<Passageiro> passageiro = (ArrayList<Passageiro>)
		// formacaoService.listar();
		//
		// ModelAndView modelAndView = new ModelAndView("consultarPassageiro").addObject("passageiro",
		// passageiro);
		// return modelAndView;

		return null;

	}
	
}
